package com.example.doancoso3.ui.testfirebase.testitem

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance().collection("items")

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> = _items

    private var itemsListener: ListenerRegistration? = null

    init {
//        db.addSnapshotListener { snapshot, _ ->
//            snapshot?.let {
//                _items.value = it.documents.map { doc ->
//                    Item(id = doc.id, name = doc.getString("name") ?: "")
//                }
//            }
//        }
        fetchItems()

    }
    private fun fetchItems() {
        viewModelScope.launch {
            db.addSnapshotListener { snapshot, _ ->
                snapshot?.let {
                    val itemsList = it.documents.map { doc ->
                        Item(id = doc.id, name = doc.getString("name") ?: "")
                    }
                    if (itemsList != _items.value) {
                        _items.value = itemsList
                    }
                }
            }
        }
    }
    private fun observeItems() {
        itemsListener = db.addSnapshotListener { snapshot, _ ->
            val itemsList = mutableListOf<Item>()
            snapshot?.documents?.forEach { doc ->
                val item = doc.toObject(Item::class.java)
                item?.let { itemsList.add(it) }
            }
            _items.value = itemsList
        }
    }

    fun addData(name: String) {
        val newItem = hashMapOf("name" to name)
        db.add(newItem)
    }

    fun getItem(itemId: String): StateFlow<Item?> {
        val itemRef = db.document(itemId)
        val itemStateFlow = MutableStateFlow<Item?>(null)
        itemRef.addSnapshotListener { snapshot, _ ->
            val item = snapshot?.toObject(Item::class.java)
            itemStateFlow.value = item
        }
        return itemStateFlow
    }

    fun updateData(itemId: String, name: String) {
        db.document(itemId).update("name", name)
    }

    fun deleteData(itemId: String) {
        db.document(itemId).delete()
    }

    override fun onCleared() {
        super.onCleared()
        itemsListener?.remove()
    }
    //


fun getData2(items: MutableState<List<Item>>) {
    val db = Firebase.firestore.collection("items").get().addOnSuccessListener{
        result ->
        val itemList = result.map { documet ->
            documet.getString(documet.id)?.let {
                Item(
                    id = it,
                    name = documet.getString("name")!!
                )
            }
        }
        items.value = itemList as List<Item>
    }
        .addOnFailureListener { exception ->
            Toast.makeText(null, "Failed to load data", Toast.LENGTH_SHORT).show()
            Log.w(TAG, "Failed to load data: ", exception)
        }

}

fun updateCourse(item: Item, onSuccess: () -> Unit) {
    val db = FirebaseFirestore.getInstance()
    db.collection("Course").document(item.id)
        .set(item.name)
        .addOnSuccessListener {
            Log.d("Firestore", "DocumentSnapshot successfully updated!")
            onSuccess()
        }
        .addOnFailureListener { e ->
            Log.w("Firestore", "Error updating document", e)
        }
}

fun deleteCourse(courseID: String, onSuccess: () -> Unit) {
    val db = FirebaseFirestore.getInstance()
    db.collection("Course").document(courseID)
        .delete()
        .addOnSuccessListener {
            Log.d("Firestore", "DocumentSnapshot successfully deleted!")
            onSuccess()
        }
        .addOnFailureListener { e ->
            Log.w("Firestore", "Error deleting document", e)
        }
}
}

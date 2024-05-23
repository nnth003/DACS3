package com.example.doancoso3.ui.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class ViewModelDACS3 : ViewModel() {
    //    private val dbsanpham = FirebaseFirestore.getInstance().collection("items")
//    private val _items = MutableStateFlow<List<UrlAnhDS>>(emptyList())
//    val items: StateFlow<List<UrlAnhDS>> = _items

    private val _productList = MutableStateFlow<List<ProductList>>(emptyList())
    val product: StateFlow<List<ProductList>> = _productList


    init {
        viewModelScope.launch {
            fetchItems()
        }

    }

    suspend fun fetchItems() {
        val firestore = FirebaseFirestore.getInstance()
        val collection = firestore.collection("sanpham")
        // Thêm snapshot listener để theo dõi các thay đổi
        collection.addSnapshotListener { snapshot, e ->
            if (e != null) {
                // Xử lý lỗi
                return@addSnapshotListener
            }
            if (snapshot != null) {
                val product = snapshot.documents.mapNotNull { document ->
                    val id = document.id.toInt()
                    val ten = document.getString("ten")
                    val anh = document.getString("anh")
                    if (ten != null && anh != null) {
                        ProductList(id, ten, anh)
                    } else {
                        null
                    }
                }
                // Cập nhật StateFlow khi có dữ liệu mới
                _productList.value = product.toList()
            }
        }
    }

    fun addSanPham(ten: String, anh: String) {
        viewModelScope.launch {
            val firestore = FirebaseFirestore.getInstance()
            val counterDocument = firestore.collection("counters").document("sanphamCounter")
            try {
                firestore.runTransaction { transaction ->
                    val snapshot = transaction.get(counterDocument)
                    val currentId = snapshot.getLong("currentId")?.toInt() ?: 0
                    val newId = currentId + 1
                    transaction.update(counterDocument, "currentId", newId)
                    newId
                }.addOnSuccessListener { newId ->
                    val newSanPham = ProductList(id = newId, name = ten, imgae = anh)
                    viewModelScope.launch {
                        firestore.collection("sanpham").document(newId.toString()).set(newSanPham)
                            .await()
                        fetchItems()  // Refresh list
                    }
                }
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

}
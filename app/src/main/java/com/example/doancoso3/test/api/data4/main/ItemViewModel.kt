//package com.example.doancoso3.test.api.data4.main
//
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.withContext
//class ItemViewModel : ViewModel() {
//    private val _items = MutableStateFlow<List<Item>>(emptyList())
////    private val _items = MutableLiveData<List<Item>>()
//    val items: MutableStateFlow<List<Item>> = _items
//
//    private val _selectedItem = MutableStateFlow<Item?>(null)
//    val selectedItem: StateFlow<Item?> = _selectedItem
//
//    fun fetchItems() {
//        viewModelScope.launch {
//            val apiService4 = ApiService.getInstance()
//            try {
//                _items.value =apiService4.getItems()
//            }catch (e: Exception){
//
//            }
//        }
//    }
//
//    fun fetchItemDetails(id: Int) {
//        viewModelScope.launch {
//            val itemDetails = withContext(Dispatchers.IO) {
//                ApiService.getInstance().getItem(id)
//            }
////            _selectedItem.value = itemDetails
//        }
//    }
//
//    fun addItem(name: String, description: String) {
//        viewModelScope.launch {
//            val apiService4 = ApiService.getInstance()
//            try {
//                val new = apiService4.addItem(name, description)
//                _items.value = _items.value.orEmpty() + new
//            }catch (e: Exception){
//
//            }
//        }
//    }
//
//    fun updateItem(id: Int, name: String, description: String) {
//        viewModelScope.launch {
//            withContext(Dispatchers.IO) {
//                ApiService.getInstance().updateItem(id, name, description)
//            }
////            fetchItems()
//        }
//    }
//
//    fun deleteItem(id: Int) {
//        viewModelScope.launch {
//            withContext(Dispatchers.IO) {
//                ApiService.getInstance().deleteItem(id)
//            }
////            fetchItems()
//        }
//    }
//}
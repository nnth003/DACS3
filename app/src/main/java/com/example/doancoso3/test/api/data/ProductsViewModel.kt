//package com.example.doancoso3.test.api.data
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.doancoso3.ui.api.data.model.Product
//import kotlinx.coroutines.channels.Channel
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.flow.collectLatest
//import kotlinx.coroutines.flow.receiveAsFlow
//import kotlinx.coroutines.flow.update
//import kotlinx.coroutines.launch
//
//class ProductsViewModel(
//    private val productsRepository: com.example.doancoso3.test.api.data.ProductsRepository
//): ViewModel() {
//
//    private val _products = MutableStateFlow<List<Product>>(emptyList())
//    val products = _products.asStateFlow()
//
//    private val _showErrorToastChannel = Channel<Boolean>()
//    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()
//
//    init {
//        viewModelScope.launch {
//            productsRepository.getProductsList().collectLatest { result ->
//                when(result) {
//                    is com.example.doancoso3.test.api.data.Result.Error -> {
//                        _showErrorToastChannel.send(true)
//                    }
//                    is _root_ide_package_.com.example.doancoso3.test.api.data.Result.Success -> {
//                        result.data?.let { products ->
//                            _products.update { products }
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//}
package com.example.doancoso3.ui.dacs3.testapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//class VM : ViewModel() {
//    private val productService: apitest = Retrofit.Builder()
//        .baseUrl("https://apidacs3.000webhostapp.com/UserApi/") // Thay đổi URL của bạn ở đây
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//        .create(apitest::class.java)
//
//    private val _searchText = MutableStateFlow("")
//    val searchText = _searchText.asStateFlow()
//
//    private val _isSearching = MutableStateFlow(false)
//    val isSearching = _isSearching.asStateFlow()
//
//    private val _products = MutableStateFlow<List<Product>>(emptyList())
//    val products: StateFlow<List<Product>> = searchText
//        .debounce(1000L)
//        .onEach { _isSearching.update { true } }
//        .flatMapLatest { searchTerm ->
//            if (searchTerm.isBlank()) {
//                flowOf(emptyList())
//            } else {
//                flow {
//                    val products = productService.searchProducts(searchTerm)
//                    emit(products)
//                }.catch { emit(emptyList()) }
//            }
//        }
//        .onEach { _isSearching.update { false } }
//        .stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(5000),
//            initialValue = emptyList()
//        )
//
//    fun onSearchTextChange(text: String) {
//        _searchText.value = text
//    }
//}


//
//@OptIn(FlowPreview::class)
//class VM : ViewModel() {
//    private val _searchText = MutableStateFlow("")
//    val searchText = _searchText.asStateFlow()
//
//    private val _isSearching = MutableStateFlow(false)
//    val isSearching = _isSearching.asStateFlow()
//
//    private val _persons = MutableStateFlow(allPersons)
//    val persons = searchText
//        .debounce(1000L)
//        .onEach { _isSearching.update { true } }
//        .combine(_persons) { text, persons ->
//            if (text.isBlank()) {
//                persons
//            } else {
//                delay(2000L)
//                persons.filter {
//                    it.doesMatchSearchQuery(text)
//                }
//            }
//        }
//        .onEach { _isSearching.update { false } }
//        .stateIn(
//            scope = viewModelScope,
//            SharingStarted.WhileSubscribed(5000),
//            _persons.value
//        )
//
//    fun onSearchTextChange(text: String) {
//        _searchText.value = text
//    }
//}
//
//data class Person(
//    val firstName: String,
//    val lastName: String
//) {
//    fun doesMatchSearchQuery(query: String): Boolean {
//        val matchingCombinations = listOf(
//            "$firstName$lastName",
//            "$firstName $lastName",
//            "${firstName.first()} ${lastName.first()}",
//        )
//
//        return matchingCombinations.any {
//            it.contains(query, ignoreCase = true)
//        }
//    }
//}
//
//private val allPersons = listOf(
//    Person(
//        firstName = "Philipp",
//        lastName = "Lackner"
//    ),
//    Person(
//        firstName = "Beff",
//        lastName = "Jezos"
//    ),
//    Person(
//        firstName = "Chris P.",
//        lastName = "Bacon"
//    ),
//    Person(
//        firstName = "Jeve",
//        lastName = "Stops"
//    ),
//)
//

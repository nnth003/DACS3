package com.example.doancoso3.ui.dacs3.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.doancoso3.ui.dacs3.model.Api
import com.example.doancoso3.ui.dacs3.model.chitietdonhang
import com.example.doancoso3.ui.dacs3.model.danhmuc
import com.example.doancoso3.ui.dacs3.model.donhang
import com.example.doancoso3.ui.dacs3.model.giohang
import com.example.doancoso3.ui.dacs3.model.sanpham
import com.example.doancoso3.ui.dacs3.model.tonggia
import com.example.doancoso3.ui.dacs3.model.users
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ViewModelDA : ViewModel() {
    private val _sanpham = MutableStateFlow<List<sanpham>>(emptyList())
    val sanpham: StateFlow<List<sanpham>> = _sanpham

    private val _danhmuc = MutableStateFlow<List<danhmuc>>(emptyList())
    val danhmuc: MutableStateFlow<List<danhmuc>> = _danhmuc

    private val _giohang = MutableStateFlow<List<giohang>>(emptyList())
    val giohang: MutableStateFlow<List<giohang>> = _giohang

    private val _tonggia = MutableStateFlow<List<tonggia>>(emptyList())
    val tonggia: MutableStateFlow<List<tonggia>> = _tonggia

    private val _donhang = MutableStateFlow<List<donhang>>(emptyList())
    val donhang: MutableStateFlow<List<donhang>> = _donhang

    private val _chitietdonhang = MutableStateFlow<List<chitietdonhang>>(emptyList())
    val chitietdonhang: MutableStateFlow<List<chitietdonhang>> = _chitietdonhang


    private val _authCheck = MutableStateFlow<List<users>>(emptyList())
    val authCheck: MutableStateFlow<List<users>> = _authCheck

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> get() = _isLoggedIn

    var user by mutableStateOf(Firebase.auth.currentUser)

    var errorMessage: String by mutableStateOf("")

    //Search
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _products = MutableStateFlow<List<sanpham>>(emptyList())
    val products: StateFlow<List<sanpham>> = searchText
        //Wait 1s after enter text
        .debounce(1000L)
        .onEach { _isSearching.update { true } }
        //call API when change search Text
        .flatMapLatest { search ->
            if (search.isBlank()) {
                flowOf(emptyList())
            } else {
                flow {
                    val products = Api.getInstance().searchProducts(search)
                    emit(products)
                }.catch { emit(emptyList()) }
            }
        }
        .onEach { _isSearching.update { false } }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }
    fun login() {
        _isLoggedIn.value = true
    }

    fun logout() {
        _isLoggedIn.value = false
//        _authCheck.value = emptyList()
    }

    fun clearProductList(){
        _sanpham.value = emptyList()
    }
    fun getDanhMuc() {
        viewModelScope.launch {
            val api = Api.getInstance()
            try {
                _danhmuc.value = api.getDanhMuc()
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun getSanPham() {
        viewModelScope.launch {
            val api = Api.getInstance()
            try {
                _sanpham.value = api.getDanhSachSanPham()
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun getSanPhamByIdDanhMuc(id: Int) {
        viewModelScope.launch {
            val api = Api.getInstance()
            try {
                _sanpham.value = api.getSanPhamByIdDanhMuc(id)
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun getSanPhamByIdSanPham(id: Int) {
        viewModelScope.launch {
            val api = Api.getInstance()
            try {
                _sanpham.value = api.getSanPhamByIdSanPham(id)
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun getGioHang(id: Int) {
        viewModelScope.launch {
            val api = Api.getInstance()
            try {
                _giohang.value = api.getGioHang(id)
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
    fun getDonHang(id: Int) {
        viewModelScope.launch {
            val api = Api.getInstance()
            try {
                _donhang.value = api.getdonhang(id)
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
    fun getChiTietDonHang(id: Int) {
        viewModelScope.launch {
            val api = Api.getInstance()
            try {
                _chitietdonhang.value = api.getchitietdonhang(id)
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun getTongGia(id: Int) {
        viewModelScope.launch {
            val api = Api.getInstance()
            try {
                _tonggia.value = api.getTongGia(id)
                getGioHang(id)
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun getUpdateCart(id: Int, iduser: Int, soluong: Int) {
        viewModelScope.launch {
            val api = Api.getInstance()
            try {
                _giohang.value = api.getUpadateCart(id, soluong, iduser)
//                getTongGia(iduser)
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun addToCart(iduser: Int, idsp: Int, tensanpham: String, anh: String, gia: Int, soluong: Int) {
        viewModelScope.launch {
            val api = Api.getInstance()
            try {
                _giohang.value = api.addToCart(iduser, idsp, tensanpham, anh, gia, soluong)
//                getGioHang()
                getTongGia(iduser)
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun deleteCart(idsp: Int, iduser: Int) {
        viewModelScope.launch {
            val api = Api.getInstance()
            try {
                _giohang.value = api.deleteCart(idsp, iduser)
                getGioHang(iduser)
                getTongGia(iduser)
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun auth_check(username: String, password: String) {
        viewModelScope.launch {
            val api = Api.getInstance()
            try {
                _authCheck.value = api.auth(username, password)
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun register(
        user: String,
        email: String,
        pass: String,
        ten: String,
        sdt: String,
        diachi: String
    ) {
        viewModelScope.launch {
            val api = Api.getInstance()
            try {
                api.register(user, email, pass, ten, sdt, diachi)
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
    fun updateUser(
        iduser: Int,
        user: String,
        email: String,
        pass: String,
        ten: String,
        sdt: String,
        diachi: String
    ) {
        viewModelScope.launch {
            val api = Api.getInstance()
            try {
                _authCheck.value = api.updateUser(iduser, user, email, pass, ten, sdt, diachi)
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun add_donhang(iduser: Int, diachi: String, sdt: Int) {
        viewModelScope.launch {
            val api = Api.getInstance()
            try {
                api.add_donhang(iduser, diachi, sdt)
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}
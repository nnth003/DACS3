//package com.example.doancoso3.ui.dacs3.viewmodel
//
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.doancoso3.test.data.CartList
//import com.example.doancoso3.test.data.ProductList
//import com.google.firebase.firestore.FirebaseFirestore
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.tasks.await
//
//class ViewModelDACS3 : ViewModel() {
//    //    private val dbsanpham = FirebaseFirestore.getInstance().collection("items")
////    private val _items = MutableStateFlow<List<UrlAnhDS>>(emptyList())
////    val items: StateFlow<List<UrlAnhDS>> = _items
//
//    private val _productList = MutableStateFlow<List<ProductList>>(emptyList())
//    val product: StateFlow<List<ProductList>> = _productList
//
//    private val _cartList = MutableStateFlow<List<CartList>>(emptyList())
//    val cart: StateFlow<List<CartList>> = _cartList
//
//    private val _soluong = MutableStateFlow(1)
//    val soluong: StateFlow<Int> = _soluong
//
//    private val _gia = MutableStateFlow(0)
//    val gia: StateFlow<Int> = _gia
//    private val _totalGia = MutableStateFlow(0L)
//    val totalGia: StateFlow<Long> = _totalGia
//
//    private var nameUser by mutableStateOf("")
//    private var phoneUser by mutableStateOf("")
//    private var localUser by mutableStateOf("")
//    private var messageUser by mutableStateOf("")
//
//    private val cartList = MutableStateFlow<CartList?>(null)
//
//    var isLogged = false
//
//    var appJustLaunched by mutableStateOf(true)
//    var userIsAuthenticated by  mutableStateOf(false)
//
//
//    init {
//        viewModelScope.launch {
//            fetchItems()
//        }
//        viewModelScope.launch {
//            fetchCart()
//        }
//        viewModelScope.launch {
////            fetchCartById()
//        }
//    }
//
//    fun setDataUser(name: String, phone: String, local: String, message: String){
//        nameUser = name
//        phoneUser = phone
//        localUser = local
//        messageUser = message
//    }
//
//    private fun fetchItems() {
//        val firestore = FirebaseFirestore.getInstance()
//        val collection = firestore.collection("sanpham")
//        // Thêm snapshot listener để theo dõi các thay đổi
//        collection.addSnapshotListener { snapshot, e ->
//            if (e != null) {
//                e.printStackTrace()
//                return@addSnapshotListener
//            }
//            if (snapshot != null) {
//                val product = snapshot.documents.mapNotNull { document ->
//                    val id = document.id.toInt()
//                    val ten = document.getString("ten")
//                    val anh = document.getString("anh")
//                    val gia = document.getString("gia")
//                    val soluong = document.getString("soluong")
//                    if (ten != null && anh != null) {
//                        if (gia != null && soluong != null) {
//                            ProductList(id, ten, anh, gia, soluong)
//                        } else {
//                            null
//                        }
//                    } else {
//                        null
//                    }
//                }
//                // Cập nhật StateFlow khi có dữ liệu mới
//                _productList.value = product.toList()
//            }
//        }
//    }
//
//    private fun fetchCart() {
//        val firestore = FirebaseFirestore.getInstance()
//        val collection = firestore.collection("giohang")
//        // Thêm snapshot listener để theo dõi các thay đổi
//        collection.addSnapshotListener { snapshot, e ->
//            if (e != null) {
//                e.printStackTrace()
//                return@addSnapshotListener
//            }
//            if (snapshot != null) {
//                val cart = snapshot.documents.mapNotNull { document ->
////                    cartCounter = document.id.toInt()
//                    val id = document.id.toInt()
//                    val ten = document.getString("ten")
//                    val anh = document.getString("anh")
//                    var gia = document.getString("gia")
//                    val giabandau = document.getString("giabandau")
//                    val soluong = document.getString("soluong")
////                    if (gia  != null && giabandau != null &&gia.toInt() == giabandau.toInt())
//                    if (checkNull(
//                            id,
//                            ten,
//                            anh,
//                            gia,
//                            giabandau,
//                            soluong
//                        ) && gia?.toInt() == giabandau?.toInt()
//                    ){
//                        gia = giabandau
//                    }
//                        if (ten != null && anh != null) {
//                            if (soluong != null && gia != null && giabandau != null) {
//                                CartList(id, ten, anh, gia, giabandau, soluong)
//                            } else {
//                                null
//                            }
//                        } else {
//                            null
//                        }
//                }
//                // Cập nhật StateFlow khi có dữ liệu mới
//                _cartList.value = cart.toList()
//            }
//            viewModelScope.launch {
//                firestore.collection("giohang")
//                    .get()
//                    .addOnSuccessListener { result ->
//                        var total = 0L
//                        for (document in result) {
//                            val gia = document.getString("gia")?.toLongOrNull() ?: 0L
//                            total += gia
//                        }
//                        _totalGia.value = total
//                    }
//            }
//        }
//    }
//    fun checkStatusLogin(user: String, name: String):Boolean{
//
//        return isLogged
//    }
//    fun login() {
//        userIsAuthenticated = true
//        appJustLaunched = false
//    }
//    fun logout() {
//        userIsAuthenticated = false
//    }
//    fun checkNull(vararg input: Any?): Boolean {
//        return input.all { it != null }
//    }
//
//    fun addProductItem(ten: String, anh: String) {
////        viewModelScope.launch {
////            val firestore = FirebaseFirestore.getInstance()
////            val productCollection = firestore.collection("sanpham")
////            try {
////                val newProductItem = ProductList(0, ten, anh)
////                productCollection.add(newProductItem).await()
////            } catch (e: Exception) {
////                // Xử lý lỗi
////            }
////        }
//    }
//
//    fun updateProductItem(id: Int, ten: String, anh: String) {
//        viewModelScope.launch {
//            val firestore = FirebaseFirestore.getInstance()
//            val productDocument = firestore.collection("sanpham").document(id.toString())
//            try {
//                productDocument.update(mapOf("ten" to ten, "anh" to anh)).await()
//            } catch (e: Exception) {
//                // Xử lý lỗi
//            }
//        }
//    }
//
//    fun deleteProductItem(id: Int) {
//        viewModelScope.launch {
//            val firestore = FirebaseFirestore.getInstance()
//            val productDocument = firestore.collection("sanpham").document(id.toString())
//            try {
//                productDocument.delete().await()
//            } catch (e: Exception) {
//                // Xử lý lỗi
//            }
//        }
//    }
//
//    private fun fetchCartById(id: Int) {
//        val firestore = FirebaseFirestore.getInstance()
//
//        viewModelScope.launch {
//            try {
//                val docRef = firestore.collection("giohang").document(id.toString())
//                val snapshot = docRef.get().await()
//                if (snapshot.exists()) {
//                    _soluong.value = snapshot.getString("soluong")?.toInt() ?: 0
//                    _gia.value = snapshot.getString("gia")?.toInt() ?: 0
//                } else {
//                }
//            } catch (e: Exception) {
//            }
//        }
//    }
//
//    //Giỏ hàng
//    fun increaseValues(id: Int, soluong: Int, gia: Int) {
//        val soluongNew = soluong + 1
//        val giaNew = gia * soluongNew
//        updateCartToFirestore(id, soluongNew, giaNew)
//        fetchCart()
//    }
//
//    fun decreaseValues(id: Int, soluong: Int, gia: Int) {
//        var soluongNew = 0
//        var giaNew = 0
//        if (soluong > 1) {
//            soluongNew = soluong - 1
//        } else {
//            soluongNew = 1
//        }
//        giaNew = gia * soluongNew
//        updateCartToFirestore(id, soluongNew, giaNew)
//        fetchCart()
//
//    }
//
//    private fun updateCartToFirestore(id: Int, soluong: Int, gia: Int) {
//        val firestore = FirebaseFirestore.getInstance()
//        viewModelScope.launch {
//            try {
//                val document = firestore
//                    .collection("giohang")
//                    .document(id.toString())
//                document.update(
//                    mapOf(
//                        "soluong" to soluong.toString(),
//                        "gia" to gia.toString()
//                    )
//                ).await()
//                fetchCart()
//            } catch (e: Exception) {
//
//            } finally {
//
//            }
//        }
//    }
//
//    fun addCartItem(id: Int, ten: String, anh: String, gia: String, soluong: String) {
//        viewModelScope.launch {
//            val firestore = FirebaseFirestore.getInstance()
//            val collection = firestore.collection("giohang")
//
//            try {
//                val counter = collection.get().await()
//                val docId = if (!counter.isEmpty) {
//                    counter.documents.last().id.toInt()
//                } else {
//                    0
//                }
//
//                val newCartItem = hashMapOf(
//                    "id" to id,
//                    "ten" to ten,
//                    "anh" to anh,
//                    "gia" to gia,
//                    "soluong" to soluong
//                )
//
//                collection
//                    .document((docId + 1).toString())
//                    .set(newCartItem)
//                    .addOnSuccessListener {
//                        println("New cart item added successfully")
//                        fetchCart()
//                    }
//                    .addOnFailureListener { e ->
//                        println("Error adding cart item: $e")
//                    }
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//
//    }
//
//    fun deleteCartItem(id: Int) {
//        viewModelScope.launch {
//            val firestore = FirebaseFirestore.getInstance()
//            val cartDocument = firestore.collection("giohang").document(id.toString())
//            try {
//                cartDocument.delete().await()
//            } catch (e: Exception) {
//                // Xử lý lỗi
//            }
//        }
//    }
//
//    fun clearCart() {
//        viewModelScope.launch {
//            val firestore = FirebaseFirestore.getInstance()
//            val cartCollection = firestore.collection("giohang")
//            try {
//                cartCollection.get().await().documents.forEach { document ->
//                    document.reference.delete()
//                }
//            } catch (e: Exception) {
//                // Xử lý lỗi
//            }
//        }
//    }
//    // Checkout
//    fun addDonHang(iduser: Int, ten: String, diachi: String, sdt: String, tonggia: String) {
//        viewModelScope.launch {
//            val firestore = FirebaseFirestore.getInstance()
//            val collection = firestore.collection("donhang")
//
//            try {
//                val counter = collection.get().await()
//                val docId = if (!counter.isEmpty) {
//                    counter.documents.last().id.toInt()
//                } else {
//                    0
//                }
//
//                val newCartItem = hashMapOf(
//                    "iduser" to iduser,
//                    "ten" to ten,
//                    "diachi" to diachi,
//                    "sdt" to sdt,
//                    "tonggia" to tonggia
//                )
//
//                collection
//                    .document((docId + 1).toString())
//                    .set(newCartItem)
//                    .addOnSuccessListener {
//                        println("New cart item added successfully")
//                        fetchCart()
//                    }
//                    .addOnFailureListener { e ->
//                        println("Error adding cart item: $e")
//                    }
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//
//    }
//}
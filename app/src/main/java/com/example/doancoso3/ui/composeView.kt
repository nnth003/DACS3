//package com.example.doancoso3.ui
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.unit.dp
//import coil.compose.rememberImagePainter
//import com.example.doancoso3.ui.data.ProductList
//import com.google.firebase.firestore.FirebaseFirestore
//import kotlinx.coroutines.tasks.await
//
//
//@Composable
//fun SanPhamListScreen() {
//    var sanPhamList by remember { mutableStateOf(listOf<ProductList>()) }
//
//    LaunchedEffect(Unit) {
//        sanPhamList = getSanPhamList()
//    }
//
//    LazyColumn(
//        modifier = Modifier.fillMaxSize().padding(16.dp)
//    ) {
//        items(sanPhamList) { sanPham ->
//            SanPhamItem(sanPham)
//        }
//    }
//}
//
//@Composable
//fun SanPhamItem(sp: ProductList) {
//    Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
//        Image(
//            painter = rememberImagePainter(sp.image),
//            contentDescription = sp.name,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp),
//            contentScale = ContentScale.Crop
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(text = sp.name, style = MaterialTheme.typography.headlineSmall)
//    }
//}
//
//suspend fun getSanPhamList(): List<ProductList> {
//    val firestore = FirebaseFirestore.getInstance()
//    val sanphamCollection = firestore.collection("sanpham")
//    return try {
//        val snapshot = sanphamCollection.get().await()
//        snapshot.documents.mapNotNull { document ->
//            val id = document.id.toInt()
//            val ten = document.getString("ten")
//            val anh = document.getString("anh")
//            if (ten != null && anh != null) {
//                ProductList(id, ten, anh)
//            } else {
//                null
//            }
//        }
//    } catch (e: Exception) {
//        emptyList()
//    }
//}
//
//
//
////
////@Composable
////fun ProductListScreen(viewModel: ViewModelDACS3) {
////    val productList by remember{ viewModel.product}
////
////    LazyColumn(modifier = Modifier.fillMaxSize()) {
////        items(productList) { product ->
////            ProductItem(product)
////        }
////    }
////}
////
////@Composable
////fun ProductItem(product: UrlAnhDS) {
////    Row(
////        modifier = Modifier
////            .fillMaxWidth()
////            .padding(8.dp)
////            .background(Color.White)
////            .padding(16.dp),
////        verticalAlignment = Alignment.CenterVertically,
////        horizontalArrangement = Arrangement.Center
////    ) {
////        Image(
////            painter = rememberImagePainter(product.anh2),
////            contentDescription = null,
////            modifier = Modifier
////                .size(64.dp)
////                .clip(RoundedCornerShape(8.dp))
////        )
////        Spacer(modifier = Modifier.width(16.dp))
////        Text(
////            text = product.namesp,
////            style = MaterialTheme.typography.bodyMedium
////        )
////    }
////}

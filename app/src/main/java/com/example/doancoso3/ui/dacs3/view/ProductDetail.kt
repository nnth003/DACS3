package com.example.doancoso3.ui.dacs3.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.doancoso3.ui.dacs3.viewmodel.ViewModelDA
import com.example.doancoso3.ui.dacs3.view.navigation.RouteScreen

val textColor = Color(0xFFB1B1B1)

@Composable
fun ProductDetail(
    viewModelDA: ViewModelDA,
    navController: NavHostController,
    id: Int
) {
    LaunchedEffect(Unit) {
        viewModelDA.getSanPhamByIdSanPham(id)
    }
    val context = LocalContext.current
    val sanpham by viewModelDA.sanpham.collectAsState()
    val auth_id by viewModelDA.authCheck.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(bottom = 16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        if (sanpham.isNotEmpty()) {
            val product = sanpham[0]
            val url = "https://haintweb.io.vn/img/${product.image}"
            Log.d("IDUSER", "ID: ${auth_id[0].iduser}")

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                ImageSection(
                    url,
                    Color.White,
                    Modifier.clickable {
                        navController.popBackStack()
//                        viewModelDA.getSanPham()
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                AboutSection(
                    product.TenSanPham,
                    productDescription = "Giá ban đầu: ${currencyFormatter(amount = product.GiaBanDau * 1000)}",
//                rating = product.rating,
                    price = "Giá sản phẩm: "+ currencyFormatter(amount = product.Gia * 1000),
                    text = product.soluotdanhgia.toString()
                )
                Spacer(modifier = Modifier.height(24.dp))
//            SizeSection()
//                Spacer(modifier = Modifier.height(24.dp))
                DescriptionSection(product.mota)
            }
            AddToCartSection(
                modifier = Modifier.align(Alignment.End),
                color = Color.White,
                onSelected = {
                    navController.navigate("${RouteScreen.Cart.route}/${auth_id[0].iduser}")
                    viewModelDA.addToCart(
                        auth_id[0].iduser,
                        product.ID,
                        product.TenSanPham,
                        product.image,
                        product.Gia,
                        product.SoLuong
                    )
                    Log.d("AddToCart", "ID sản phẩm: ${product.ID}, Số lượng: ${product.SoLuong}")
                }
            )
        }
    }
}

@Composable
fun ImageSection(
    image: String,
    color: Color,
    modifier: Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f)
            .background(color, shape = RoundedCornerShape(24.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                modifier = modifier
            )
//            HeartSection()
        }

        Image(
            painter = rememberAsyncImagePainter(model = image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .align(Alignment.Center),
            contentScale = ContentScale.Inside
        )
    }
}

@Composable
fun AboutSection(
    name: String,
    productDescription: String,
//    rating: String,
    price: String,
    text: String
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = name, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = productDescription, color = textColor)
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = Color(0xFFFFC000)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = text)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "(Avg. Rating)")
            }
            Text(
                text = price,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

//@Composable
//fun SizeSection() {
//    Column {
//        Text(text = "Select Size", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
//        Spacer(modifier = Modifier.height(12.dp))
//        LazyRow(
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            items(size) {
//                SizeItem(it.toString())
//                Spacer(modifier = Modifier.width(12.dp))
//            }
//        }
//    }
//}

@Composable
fun SizeItem(
    size: String
) {
    Box(
        modifier = Modifier
            .size(60.dp)
            .border(1.dp, textColor, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(text = size, fontSize = 18.sp, color = textColor)
    }
}

@Composable
fun DescriptionSection(
    description: String
) {
    Text(text = "Mô tả sản phẩm", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
    LazyColumn(
        modifier = Modifier.height(200.dp)
    ) {
        item {
//            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = description,
                color = textColor,
//                maxLines = 10
            )
        }

    }
}

@Composable
fun AddToCartSection(modifier: Modifier, color: Color, onSelected: () -> Unit) {
    Box(
        modifier = modifier
            .size(120.dp, 60.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(
                    topStart = 30.dp,
                    bottomStart = 30.dp,
                    bottomEnd = 0.dp,
                    topEnd = 0.dp
                )
            )
            .clickable(onClick = onSelected),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Add", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}


@Composable
fun HeartSection() {
    Box(
        modifier = Modifier
            .size(36.dp)
            .background(Color.White, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = null,
            tint = Color.Red,
            modifier = Modifier.size(18.dp)
        )
    }
}

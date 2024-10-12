package com.example.doancoso3.ui.dacs3.view

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.doancoso3.R
import com.example.doancoso3.ui.dacs3.viewmodel.ViewModelDA
import com.example.doancoso3.ui.dacs3.model.sanpham
import com.example.doancoso3.ui.dacs3.view.navigation.RouteScreen

val searchText = mutableStateOf("")

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductList(
    navController: NavHostController,
    viewModelDA: ViewModelDA,
    id: Int
) {
    LaunchedEffect(Unit) {
        viewModelDA.getSanPhamByIdDanhMuc(id)

    }
    val sanpham by viewModelDA.sanpham.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                ),
                title = {
                    Text(stringResource(R.string.danhsachsanpham))
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp()
//                        viewModelDA.clearProductList()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = ""
                        )
                    }
                }
            )
        },
    ){inner ->
        Column(
            modifier = Modifier
                .padding(inner)
//            .ListEffect()
        ) {
//            TopBar(navController)
//        Spacer(modifier = Modifier.height(16.dp))
//        SearchSection()
            Spacer(modifier = Modifier.height(24.dp))
            ProductsSection(navController, sanpham)
        }
    }

}

@Composable
fun TopBar(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color(MaterialTheme.colorScheme.primary.value)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = stringResource(R.string.back_button),
            Modifier.clickable { navController.navigateUp() }
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = stringResource(R.string.danhsachsanpham),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Text(
            text = "",
            color = Color(0xFFCDCDCD)
        )
    }
}


//@Composable
//fun SearchSection() {
//    OutlinedTextField(
//        value = searchText.value,
//        onValueChange = {
//            searchText.value = it
//        },
//        placeholder = {
//            Text(text = "Search here...", color = Color(0xFFCCCCCC))
//        },
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color(0xFFF4F4F4), shape = CircleShape),
//        shape = CircleShape,
//        singleLine = true,
//        trailingIcon = {
//            Icon(
//                imageVector = Icons.Default.Search,
//                contentDescription = null
//            )
//        }
//    )
//}

@Composable
fun ProductsSection(navController: NavHostController, sanpham: List<sanpham>) {
    LazyColumn {
        items(sanpham) { product ->
            ProductItem(
                product
            ) {
                navController.navigate(RouteScreen.ProductDetail.route + "/${product.ID}")
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ProductItem(
    sanpham: sanpham,
    onItemClick: () -> Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(Color.White)
                .clickable(onClick = onItemClick),
            contentAlignment = Alignment.Center,

            ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

//                Image(
//                    painter = rememberAsyncImagePainter("https://apidacs3.000webhostapp.com/img/${sanpham.image}"),
//                    contentDescription = null,
//                    modifier = Modifier.fillMaxWidth(0.4f)
//                )
                AsyncImage(
                    model = "https://haintweb.io.vn/img/${sanpham.image}",
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(0.4f)
                )
                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(sanpham.TenSanPham, style = MaterialTheme.typography.headlineSmall, maxLines = 3)
                    Spacer(modifier = Modifier.height(8.dp))
//                    Text(
//                        text = "Mô tả",
//                        color = Color(0xFFB1B1B1)
//                    )
//                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = currencyFormatter(amount = sanpham.Gia * 1000), fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        Spacer(modifier = Modifier.width(25.dp))
                        Text(
                            text = "Buy",
                            fontSize = 14.sp,
                            modifier = Modifier
                                .background(Color(0xCE313131), shape = CircleShape)
                                .padding(top = 4.dp, bottom = 4.dp, start = 12.dp, end = 12.dp),
                            color = textColor
                        )
                    }
                }

            }
        }
    }

}
//fun Modifier.ListEffect(): Modifier = composed {
//    var size by remember {
//        mutableStateOf(IntSize.Zero)
//    }
//    val transition = rememberInfiniteTransition()
//    val startOffsetX by transition.animateFloat(
//        initialValue = -2 * size.width.toFloat(),
//        targetValue = 2 * size.width.toFloat(),
//        animationSpec = infiniteRepeatable(
//            animation = tween(1000)
//        )
//    )
//
//    background(
//        brush = Brush.linearGradient(
//            colors = listOf(
//                Color(0xFFB8B5B5),
//                Color(0xFF8F8B8B),
//                Color(0xFFB8B5B5),
//            ),
//            start = Offset(startOffsetX, 0f),
//            end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
//        )
//    )
//        .onGloballyPositioned {
//            size = it.size
//        }
//}
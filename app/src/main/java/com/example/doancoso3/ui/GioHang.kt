package com.example.doancoso3.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.doancoso3.R
import com.example.doancoso3.ui.data.CartList
import com.example.doancoso3.ui.data.ViewModelDACS3
import com.example.doancoso3.ui.navigation.ScreenDACS3
import com.example.doancoso3.ui.theme.DoAnCoSo3Theme

//data class Go(
//    val ten: String,
//    @DrawableRes val anh: Int,
//    val gia: String
//)
//
//class DataGioHang() {
//    fun load(): List<Go> {
//        return listOf<Go>(
//            Go("Macbook", R.drawable.architecture, "19.000.000đ"),
//            Go("SamSung", R.drawable.architecture, "20.000.000đ"),
//            Go("Dell", R.drawable.architecture, "10.000.000đ"),
//        )
//    }
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    navHostController: NavHostController,
    viewModelDACS3: ViewModelDACS3,
) {
    val cartList by viewModelDACS3.cart.collectAsState()
    val totalGia by viewModelDACS3.totalGia.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.onTertiary,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(stringResource(R.string.giohang))
                },
                navigationIcon = {
                    IconButton(onClick = { navHostController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = ""
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.onTertiary,
                contentColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "Tổng tiền: $totalGia",
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 7.dp),
                    color = Color.DarkGray
                )
                Button(
                    onClick = {
                        navHostController.navigate("${ScreenDACS3.CheckOut.route}/${totalGia}")
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 2.dp)
                ) {
                    Text(text = "Thanh Toán")
                }


            }
        }
    ) { innerPadding ->
        GioHangList(cartList, modifier = Modifier.padding(innerPadding), viewModelDACS3)
    }

}

@Composable
fun GioHangList(
    cartList: List<CartList>,
    modifier: Modifier = Modifier,
    viewModelDACS3: ViewModelDACS3
) {
    LazyColumn(modifier = modifier) {
        items(cartList) { item ->
            CardGioHang(cartList = item.copy(), modifier = Modifier.padding(8.dp), viewModelDACS3)
        }
    }

}

@Composable
fun CardGioHang(cartList: CartList, modifier: Modifier = Modifier, viewModelDACS3: ViewModelDACS3) {
    var soluong by remember { mutableIntStateOf(cartList.soluong.toInt()) }

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier,
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))

            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = cartList.image),
                    contentDescription = null,
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillWidth
                )
            }
            Spacer(Modifier.width(20.dp))
            Column(modifier = Modifier.weight(1f)) {
                if (cartList.gia.toInt() == 0) {
                    cartList.gia = cartList.giabandau

                } else {
                    cartList.gia
                }
                Text(
//                    text = stringResource(go.ten),
                    text = cartList.name,
                    style = MaterialTheme.typography.titleMedium,
//                    color = Color(0xFFFCE4EC)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = cartList.gia,
                    style = MaterialTheme.typography.bodyLarge,
//                    color = Color(0xFFFCE4EC)

                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Button(
                        onClick = {
                            if (soluong > 1) soluong-- else soluong = 1
                            viewModelDACS3.decreaseValues(
                                cartList.id,
                                cartList.soluong.toInt(),
                                cartList.giabandau.toInt()
                            )
                        },
                        modifier = Modifier
                            .width(35.dp)
                            .height(25.dp),
                        contentPadding = PaddingValues(0.dp)
//                        modifier = Modifier.size(35.dp)
                    ) {
                        Text(text = "-")
                    }
                    BasicTextField(
                        value = soluong.toString(),
                        onValueChange = { },
                        modifier = Modifier
                            .width(50.dp)
                            .align(Alignment.CenterVertically),
                        textStyle = TextStyle(textAlign = TextAlign.Center),
                        readOnly = true,
                    )
                    Button(
                        onClick = {
                            soluong++
                            viewModelDACS3.increaseValues(
                                cartList.id,
                                cartList.soluong.toInt(),
                                cartList.giabandau.toInt()
                            )
                        },
                        modifier = Modifier
                            .width(35.dp)
                            .height(25.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(text = "+")
                    }
                }

            }
            Column(
                modifier = Modifier.fillMaxHeight(1f),
                verticalArrangement = Arrangement.Bottom
            ) {
                Spacer(modifier = Modifier.height(45.dp))
                Button(
                    onClick = { viewModelDACS3.deleteCartItem(cartList.id) },
                    modifier = Modifier.height(35.dp)
//                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimaryContainer)
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "",

                        )
                }
            }

        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
)
@Composable
fun GioHang() {
    DoAnCoSo3Theme(darkTheme = false) {
        val viewModelDACS3 = ViewModelDACS3()
        val navHostController = rememberNavController()
        CartScreen(navHostController, viewModelDACS3)
    }
}
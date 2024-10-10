package com.example.doancoso3.ui.dacs3.view

import android.icu.text.NumberFormat
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.runtime.mutableIntStateOf
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.doancoso3.R
import com.example.doancoso3.ui.dacs3.viewmodel.ViewModelDA
import com.example.doancoso3.ui.dacs3.model.giohang
import com.example.doancoso3.ui.dacs3.view.navigation.RouteScreen
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    navHostController: NavHostController,
    viewModelDA: ViewModelDA,
    iduser: Int,
) {
    val giohang by viewModelDA.giohang.collectAsState()
    val tongtien by viewModelDA.tonggia.collectAsState()
    LaunchedEffect(Unit) {
        viewModelDA.getGioHang(iduser)
        viewModelDA.getTongGia(iduser)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
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
            androidx.compose.material3.BottomAppBar(
                containerColor = MaterialTheme.colorScheme.onTertiary,
                contentColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                Column {
                    Row {
                        Button(
                            onClick = {
                                navHostController.navigate(RouteScreen.Home.route)
                            },
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 2.dp, end = 2.dp)
                        ) {
                            Text(text = "Trở về trang chủ")
                        }
                    }
                    Spacer(modifier = Modifier.height(1.dp))
                    Divider()
                    Spacer(modifier = Modifier.height(1.dp))

                    Row {
                        if (tongtien.isNotEmpty()) {
                            val price = tongtien[0]
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 7.dp),
                            ) {
                                Text(
                                    text = "Tổng tiền: ",
                                    color = Color.DarkGray,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    color = Color.DarkGray,
                                    textAlign = TextAlign.Center,
                                    text = currencyFormatter(amount = price.tongtien * 1000)
                                )
                            }

                            Button(
                                onClick = {
                                    navHostController.navigate("${RouteScreen.CheckOut.route}/${price.tongtien * 1000}")
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 2.dp)
                            ) {
                                Text(text = "Thanh Toán")
                            }


                        }
                    }
                }

            }
        }
    ) { innerPadding ->
        GioHangList(iduser, giohang, modifier = Modifier.padding(innerPadding), viewModelDA)
    }

}

@Composable
fun GioHangList(
    iduser: Int,
    giohangList: List<giohang>,
    modifier: Modifier = Modifier,
    viewModelDA: ViewModelDA
) {
    LazyColumn(modifier = modifier) {
        items(giohangList) { item ->
            CardGioHang(
                iduser = iduser,
                giohang = item.copy(),
                modifier = Modifier.padding(8.dp),
                viewModelDA
            )
        }
    }

}

@Composable
fun CardGioHang(
    iduser: Int,
    giohang: giohang,
    modifier: Modifier = Modifier,
    viewModelDA: ViewModelDA
) {
    var soluong by remember { mutableIntStateOf(giohang.soluong) }

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
                    painter = rememberAsyncImagePainter(model = "https://haintweb.io.vn/img/${giohang.anh}"),
                    contentDescription = null,
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillWidth
                )
            }
            Spacer(Modifier.width(20.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
//                    text = stringResource(go.ten),
                    text = giohang.tensanpham,
                    style = MaterialTheme.typography.titleMedium,
//                    color = Color(0xFFFCE4EC)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = currencyFormatter(amount = (giohang.gia).toInt() * 1000 * soluong),
                    style = MaterialTheme.typography.bodyLarge,
//                    color = Color(0xFFFCE4EC)

                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Button(
                        onClick = {
                            if (soluong > 1) soluong-- else soluong = 1
                            viewModelDA.getUpdateCart(giohang.id, soluong, iduser)
                            viewModelDA.getTongGia(iduser)
//                            viewModelDA.getGioHang()
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
                            viewModelDA.getUpdateCart(giohang.id, soluong, iduser)
                            viewModelDA.getTongGia(iduser)
//                            viewModelDA.getGioHang()
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
                    onClick = {
                        viewModelDA.deleteCart(giohang.id, iduser)
                        viewModelDA.getGioHang(iduser)
                    },
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

@Composable
fun currencyFormatter(amount: Int): String {
    return NumberFormat.getNumberInstance(Locale("vi", "VN")).format(amount) + " VNĐ"
}
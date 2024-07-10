package com.example.doancoso3.ui.dacs3.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.doancoso3.R
import com.example.doancoso3.ui.dacs3.model.ViewModelDA
import com.example.doancoso3.ui.dacs3.model.chitietdonhang

//data class Data(
//    val ten: String,
//    val soluong: Int,
//    val gia: Int
//)
//
//val sampleDataList = listOf(
//    Data("Sản phẩm A", 10, 50000),
//    Data("Sản phẩm B", 20, 150000),
//    Data("Sản phẩm C", 5, 25000),
//    Data("Sản phẩm D", 12, 80000),
//    Data("Sản phẩm E", 8, 45000),
//    Data("Sản phẩm F", 15, 120000),
//    Data("Sản phẩm G", 7, 30000),
//    Data("Sản phẩm H", 18, 200000),
//    Data("Sản phẩm I", 25, 60000),
//    Data("Sản phẩm J", 30, 90000)
//)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderDetail(
    navHostController: NavHostController,
    viewModelDA: ViewModelDA,
    iddonhang: Int?,
    trangthai: String?,
    ngay: String?,
    tonggia: String?,
) {
    val chitietdonhang by viewModelDA.chitietdonhang.collectAsState()
    LaunchedEffect(Unit) {
        if (iddonhang != null) {
            viewModelDA.getChiTietDonHang(iddonhang)
        }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                ),
                title = {
                    Text(("Chi tiết đơn hàng"))
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
    ) { innerPadding ->
        Column (
            modifier = Modifier
                .padding(innerPadding)
                .padding(start = 10.dp, end = 10.dp)
        ){
            Column(
                modifier = Modifier.padding(2.dp)
            ) {
                if (trangthai != null) {
                    InforOrder(rightText = "Trạng thái", leftText = trangthai)
                }
                Spacer(modifier = Modifier.height(5.dp))
                if (ngay != null) {
                    InforOrder(rightText = "Ngày đặt hàng", leftText = ngay)
                }
                Spacer(modifier = Modifier.height(5.dp))
//                InforOrder(rightText = "Số lượng sản phẩm", leftText = )
//                Spacer(modifier = Modifier.height(5.dp))
                if (tonggia != null) {
                    InforOrder(rightText = "Tổng giá", leftText = currencyFormatter(amount = tonggia.toInt() * 1000))
                }
            }
            Divider()
            ListCardOrder(modifier = Modifier.padding(innerPadding), chitietdonhang)
        }

    }
}

@Composable
fun InforOrder(rightText: String, leftText: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = rightText)
        Text(text = leftText)
    }
}

@Composable
fun ListCardOrder(
    modifier: Modifier,
    chitietdonhang: List<chitietdonhang>,
) {
    LazyColumn(modifier = modifier) {
        items(chitietdonhang) { item ->
            CardOrder(modifier = Modifier.padding(5.dp), item)
        }
    }
}

@Composable
fun CardOrder(
    modifier: Modifier,
    data: chitietdonhang,
) {
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
                AsyncImage(
                    model = "https://apidacs3.000webhostapp.com/img/${data.anh}",
                    contentDescription = "",
                    alignment = Alignment.Center,
                    contentScale = ContentScale.FillBounds

                )
            }
            Spacer(Modifier.width(20.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = data.tensanpham,
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = currencyFormatter(amount = data.gia * 1000),
                    style = MaterialTheme.typography.bodyLarge,

                    )
                Spacer(modifier = Modifier.height(10.dp))

            }

        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun OrderPreview() {
//    OrderDetail(
//        navHostController = rememberNavController(),
//        viewModelDA = viewModel(),
//        iddonhang = iddonhang
//    )
}
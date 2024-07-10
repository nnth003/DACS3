package com.example.doancoso3.ui.dacs3.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.ShoppingCart
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.doancoso3.ui.dacs3.model.ViewModelDA
import com.example.doancoso3.ui.dacs3.model.donhang
import java.util.Date

data class Data2(
    val ten: String,
    val ngay: Date,
    val trangthai: String,
    val gia: Double
)

val sampleData2List = listOf(
    Data2("Order# 9", Date(1668201600000), "Chờ xác nhận", 9.36),
    Data2("Order# 8", Date(1668115200000), "Đang giao hàng", 19.99),
    Data2("Order# 7", Date(1668028800000), "Hoàn thành", 49.99),
    Data2("Order# 6", Date(1667942400000), "Processing", 79.99),
    Data2("Order# 5", Date(1667856000000), "Completed", 99.99),
    Data2("Order# 4", Date(1667769600000), "Cancelled", 29.99),
    Data2("Order# 3", Date(1667683200000), "Processing", 59.99),
    Data2("Order# 2", Date(1667596800000), "Completed", 89.99),
    Data2("Order# 1", Date(1667510400000), "Cancelled", 19.99),
    Data2("Order# 0", Date(1667424000000), "Processing", 39.99)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Order(
    navHostController: NavHostController,
    viewModelDA: ViewModelDA,
    id: Int?,
) {
    LaunchedEffect(Unit) {
        if (id != null) {
            viewModelDA.getDonHang(id)
        }
    }
    val donhang by viewModelDA.donhang.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                ),
                title = {
                    Text("Đơn hàng")
                },
                navigationIcon = {
                    IconButton(onClick = { navHostController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        },
    ) { innerPadding ->

        ListTrackOrder(
            navHostController = navHostController,
            modifier = Modifier
                .padding(innerPadding)
                .padding(start = 10.dp, end = 10.dp),
            list = donhang
        )
        Divider()

    }
}

@Composable
fun ListTrackOrder(
    navHostController: NavHostController,
    modifier: Modifier,
    list: List<donhang>
) {
    LazyColumn(modifier = modifier) {
        items(list) { item ->
            CardTrack(
                modifier = Modifier
                    .padding(5.dp)
                    .clickable { navHostController.navigate("${RouteScreen.OrderDetail.route}/${item.ID}/${item.trangthai}/${item.ngay}/${item.tonggia}") },
                data = item
            )
        }
    }
}

@Composable
fun CardTrack(
    modifier: Modifier,
    data: donhang
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFEEEAF4)
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Mã đơn hàng: " + data.ID.toString(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Text(
                    text = data.ngay,
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Trạng thái: ${data.trangthai}", fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Tổng giá: $${data.tonggia}", fontSize = 14.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconWithCircle(
                    icon = Icons.Default.ShoppingCart,
                    isActive = data.trangthai == "Chờ xác nhận"
                )
                IconWithCircle(
                    icon = Icons.Default.LocalShipping,
                    isActive = data.trangthai == "Đã xác nhận và giao hàng"
                )
                IconWithCircle(
                    icon = Icons.Default.Check,
                    isActive = data.trangthai == "Hoàn thành"
                )
            }
        }
    }
}

@Composable
fun IconWithCircle(icon: ImageVector, isActive: Boolean) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .background(
                    color = if (isActive) Color.Green else Color.Red,
                    shape = CircleShape
                )
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun TrackOrderPreview() {
//    Order(navHostController = rememberNavController(), viewModelDA = viewModel(), id = id)
}

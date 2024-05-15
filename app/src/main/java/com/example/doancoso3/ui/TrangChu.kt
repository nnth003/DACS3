package com.example.doancoso3.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.doancoso3.R
import com.example.doancoso3.ui.theme.DoAnCoSo3Theme

data class DuLieu(
    @DrawableRes val anh: Int,
//    @StringRes val ten: Int,
)

class Data() {
    fun load(): List<DuLieu> {
        return listOf<DuLieu>(
//            DuLieu(R.drawable.image1, R.string.truong1),
//            DuLieu(R.drawable.image2, R.string.truong2),
//            DuLieu(R.drawable.image3, R.string.truong3),
//            DuLieu(R.drawable.image4, R.string.truong4),
//            DuLieu(R.drawable.image5, R.string.truong5),
//            DuLieu(R.drawable.image6, R.string.truong6),
//            DuLieu(R.drawable.image7, R.string.truong7),
//            DuLieu(R.drawable.image8, R.string.truong8),
//            DuLieu(R.drawable.image9, R.string.truong9),
//            DuLieu(R.drawable.image10, R.string.truong10),
            DuLieu(R.drawable.image1),
            DuLieu(R.drawable.image1),
//            DuLieu(R.drawable.image1),
//            DuLieu(R.drawable.image1),
//            DuLieu(R.drawable.image1),
//            DuLieu(R.drawable.image1),
//            DuLieu(R.drawable.image1),
//            DuLieu(R.drawable.image1),
//            DuLieu(R.drawable.image1),
//            DuLieu(R.drawable.image1),

            )
    }
}

@Composable
fun HomeScreen() {

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldHome(
    duLieu: List<DuLieu>,
    onDanhMucButton: NavController,
    route: String,
) {
    var presses by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(stringResource(R.string.trangchu))
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { /*TODO*/ }, modifier = Modifier
                        .weight(1f)
                        .padding(2.dp)
                ) {
                    Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
                }
                Button(
                    onClick = { onDanhMucButton.navigate(route) }, modifier = Modifier
                        .weight(1f)
                        .padding(2.dp)
                ) {
                    Icon(imageVector = Icons.Default.List, contentDescription = "List")
                }
                Button(
                    onClick = { /*TODO*/ }, modifier = Modifier
                        .weight(1f)
                        .padding(2.dp)
                ) {
                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Cart")
                }
                Button(
                    onClick = { /*TODO*/ }, modifier = Modifier
                        .weight(1f)
                        .padding(2.dp)
                ) {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Account")
                }

            }
        },
//        floatingActionButton = {
//            FloatingActionButton(onClick = { presses++ }) {
//                Icon(Icons.Default.Add, contentDescription = "Add")
//            }
//        }
    )
    { innerPadding ->
//        Column(
//            modifier = Modifier
//                .padding(innerPadding).fillMaxSize(),
//            verticalArrangement = Arrangement.spacedBy(16.dp),
//        ) {
////            Text(
////                modifier = Modifier.padding(8.dp),
////                text =
////                """
////                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.
////
////                    It also contains some basic inner content, such as this text.
////
////                    You have pressed the floating action button $presses times.
////                """.trimIndent(),
////            )
//
//
//        }
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
        ) {
            Text(
                text = "Danh Mục Sản Phẩm",
                modifier = Modifier
                    .padding(5.dp)
            )
            LazyRow(modifier = Modifier.padding(2.dp)) {
                item {
                    Card(
                        modifier = Modifier
                            .padding(4.dp),
                        elevation = CardDefaults
                            .cardElevation( defaultElevation = 1.dp)
                    ) {
                       Row (
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(8.dp)
                               .sizeIn(minHeight = 72.dp)

                       ){
                           Box (
                               modifier = Modifier
                                   .size(72.dp)
                                   .clip(RoundedCornerShape(8.dp))

                           ){
                                Image(
                                    painter = painterResource(R.drawable.image1) ,
                                    contentDescription = "",
                                    alignment = Alignment.Center,
                                    contentScale = ContentScale.FillBounds
                                )
                           }
                       }
                    }
                }
            }
            Text(
                text = "Danh Sách Sản Phẩm Nổi Bật",
                modifier = Modifier
                    .padding(5.dp)
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(8.dp)
            ) {
                items(duLieu.size) { item ->
                    CardSanPham(
                        item = duLieu[item],
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }

        }

    }
}

@Composable
fun CardSanPham(item: DuLieu, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(item.anh),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentScale = ContentScale.Crop
            )
            Text(
//                text = LocalContext.current.getString(item.ten),
                text = "text",
                modifier = Modifier.padding(2.dp),
                style = MaterialTheme.typography.displaySmall
            )
//            Text(
////                text = LocalContext.current.getString(truong.tenQuan),
//                text = "LocalContext.current.getString(truong.tenQuan)",
//                modifier = Modifier.padding(2.dp),
//                style = MaterialTheme.typography.displaySmall
//            )
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun TrangChu() {
    DoAnCoSo3Theme {
//        HomeScreen()
        val navController = rememberNavController()
        ScaffoldHome(Data().load(), navController, "")
    }

}
package com.example.doancoso3.ui.dacs3.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.doancoso3.R
import com.example.doancoso3.ui.dacs3.viewmodel.ViewModelDA
import com.example.doancoso3.ui.dacs3.model.sanpham
import com.example.doancoso3.ui.dacs3.view.navigation.RouteScreen

@Composable
fun Home(
    viewModel: ViewModelDA,
    navHostController: NavHostController,
) {
    LaunchedEffect(Unit) {
        viewModel.getDanhMuc()
        viewModel.getSanPham()
    }
    val danhmuc by viewModel.danhmuc.collectAsState()
    val sanpham by viewModel.sanpham.collectAsState()
    val auth_id by viewModel.authCheck.collectAsState()
    val login by viewModel.isLoggedIn.collectAsState()
//    val sanpham1 by viewModel.data.observeAsState()
    val verticalScrollState = rememberLazyGridState()
    val topBarVisibilityState = remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            AppBar(
                navController = navHostController,
                isVisible = topBarVisibilityState.value,
                onSearchClick = {
                    navHostController.navigate(RouteScreen.Search.route)
                },
                onAccountIconClick = {
                    if (login) {
                        navHostController.navigate(RouteScreen.Profile.route)
                    } else {
                        navHostController.navigate(RouteScreen.Login.route)
                    }
                }
            ) {
                if (login) {
                    navHostController.navigate("${RouteScreen.Cart.route}/${auth_id[0].iduser}")
                    Log.d("ID User", "${auth_id[0].iduser}")
                } else {
                    navHostController.navigate(RouteScreen.Login.route)
                }
            }
        },
        bottomBar = {
//            BottomAppBar()

        },
    )
    { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
        ) {
            item {
                Text(
                    text = stringResource(R.string.danhmucsanpham),
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .padding(10.dp)
                )
            }

            if (viewModel.errorMessage.isEmpty()) {
                item {
                    LazyRow(
                        modifier = Modifier
                            .padding(2.dp)
                            .background(Color.White)
                    ) {
                        items(danhmuc) { item ->
//                        Text(item.TenDanhMuc)
                            CategoryCard(
                                urlAnh = "https://haintweb.io.vn/img/${item.anh}",
                                onSelected = {
                                    navHostController.navigate("${RouteScreen.ProductList.route}/${item.IDDM}")
                                }
                            )
                            Log.d("Homeeeeeeee", "Lỗi: $danhmuc")
                        }

                    }
                }

            } else {
                item {
                    Text(viewModel.errorMessage)
                }

            }
            item {
                Text(
                    text = stringResource(R.string.danhsachsanphamnoibat),
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .padding(10.dp)
                )
            }

            if (viewModel.errorMessage.isEmpty()) {
//                LazyVerticalGrid(
//                    columns = GridCells.Fixed(2),
//                    modifier = Modifier.padding(10.dp)
//                ) {
//                    items(sanpham) { item ->
//                        ProductCard(
//                            sanpham = item.copy(),
//                            navController = navHostController
//                        ) {
//                            navHostController.navigate("${RouteScreen.ProductDetail.route}/${item.ID}")
//                            Log.e("Home","${RouteScreen.ProductDetail.route}/${item.ID}")
//                        }
//                    }
//                }
                items(sanpham.chunked(2)) { rowItems ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        for (item in rowItems) {
                            Box(
                                modifier = Modifier
//                                    .weight(1f)
                                    .padding(5.dp)
                            ) {
                                ProductCard(
                                    sanpham = item.copy(),
                                    navController = navHostController
                                ) {
                                    navHostController.navigate("${RouteScreen.ProductDetail.route}/${item.ID}")
                                }
                            }
                        }
//                        if (rowItems.size < 2) {
//                            Spacer(modifier = Modifier.weight(1f))
//                        }
                    }
                }
            } else {
                item {
                    Text(viewModel.errorMessage)
                }

            }
        }

    }
}

@Composable
fun BottomAppBar() {
    androidx.compose.material3.BottomAppBar(
        containerColor = Color.White,
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
            onClick = { }, modifier = Modifier
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
}

@Composable
fun CategoryCard(
    urlAnh: String,
    onSelected: () -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .clickable(onClick = onSelected),
        elevation = CardDefaults
            .cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(Color.White)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .sizeIn(minHeight = 72.dp)

        ) {
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))

            ) {
                AsyncImage(
                    model = urlAnh,
                    contentDescription = "",
                    alignment = Alignment.Center,
                    contentScale = ContentScale.FillBounds

                )
            }
        }
    }
}

@Composable
fun ProductCard(
    sanpham: sanpham,
    navController: NavController,
    onSelected: () -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = onSelected)
            .background(Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxSize()
                .sizeIn(minHeight = 100.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Box(
                modifier = Modifier
                    .size(160.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .align(Alignment.CenterHorizontally)
            ) {
                Column {
                    AsyncImage(
                        model = "https://haintweb.io.vn/img/${sanpham.image}",
                        contentDescription = "",
                        alignment = Alignment.Center,
                        contentScale = ContentScale.FillBounds,
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                }
            }
            Box(
                modifier = Modifier
                    .padding(start = 6.dp, top = 8.dp, bottom = 6.dp, end = 6.dp),
            ) {
                Text(
//                text = LocalContext.current.getString(item.ten),
                    text = sanpham.TenSanPham,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W400,
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    navController: NavController,
    isVisible: Boolean,
    onSearchClick: () -> Unit,
    onAccountIconClick: () -> Unit,
    onCartIconClick: () -> Unit
) {
    var typedText by remember {
        mutableStateOf(TextFieldValue())
    }
    if (isVisible) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, top = 25.dp, bottom = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
//            TextField(
//                value = typedText,
//                onValueChange = {},
//                singleLine = true,
//                placeholder = { Text(text = "Search product") },
//                leadingIcon = {
//                    Icon(
//                        imageVector = Icons.Default.Search,
//                        contentDescription = "Product Search Icon"
//                    )
//                },
//                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    focusedBorderColor = Color.Transparent,
//                    unfocusedBorderColor = Color.Transparent,
//                    cursorColor = MaterialTheme.colorScheme.primary
//                ),
//
//                modifier = Modifier
//                    .background(
//                        color = Color.LightGray,
//                        shape = RoundedCornerShape(20.dp)
//                    )
//                    .weight(1f)
//                    .clickable {
//                        onSearchClick()
//                    },
//            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
                    .background(
                        color = Color.LightGray,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .clickable {
                        onSearchClick()
                    },
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Tìm kiếm sản phẩm",
                        modifier = Modifier.padding(start = 8.dp, end = 16.dp)
                    )
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .clickable {
                        onCartIconClick()
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Cart Icon"
                )
            }
            ConstraintLayout() {
                val (notification, notificationCounter) = createRefs()

                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .constrainAs(notification) {}
                        .clickable {
                            onAccountIconClick()
                        },

                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Account Icon"
                    )

                }
                //notification count
//                Box(
//                    modifier = Modifier
//                        .size(20.dp)
//                        .background(color = Color.Red, shape = CircleShape)
//                        .padding(3.dp)
//                        .constrainAs(notificationCounter) {
//                            top.linkTo(notification.top)
//                            end.linkTo(notification.end)
//                        },
//                    contentAlignment = Alignment.Center
//                ) {
//                    Text(text = "3", fontSize = 11.sp, color = Color.White)
//                }

            }

        }
    }
}
package com.example.doancoso3.test.test2//package com.example.doancoso3.ui.screen
//
//import android.util.Log
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.sizeIn
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.foundation.lazy.grid.items
//import androidx.compose.foundation.lazy.grid.rememberLazyGridState
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.AccountCircle
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.List
//import androidx.compose.material.icons.filled.Search
//import androidx.compose.material.icons.filled.ShoppingCart
//import androidx.compose.material3.BottomAppBar
//import androidx.compose.material3.Button
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.constraintlayout.compose.ConstraintLayout
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.rememberNavController
//import coil.compose.AsyncImage
//import com.example.doancoso3.R
//import com.example.doancoso3.test.data.ProductList
//import com.example.doancoso3.ui.dacs3.viewmodel.ViewModelDACS3
//import com.example.doancoso3.ui.navigation.ScreenDACS3
//import com.example.doancoso3.ui.theme.DoAnCoSo3Theme
//
//
//@Composable
//fun ScaffoldHome(
//    viewModelDACS3: ViewModelDACS3,
//    navHostController: NavHostController,
//) {
////    var product = remember { mutableStateOf(listOf<UrlAnhDS>()) }
////    val verticalScrollState = rememberScrollState()
////    val sanphamList = remember {viewModelDACS3.product}
//
//
//    val topBarVisibilityState = remember { mutableStateOf(true) }
//    val sanPhamList by viewModelDACS3.product.collectAsState()
//    val verticalScrollState = rememberLazyGridState()
//
//    LaunchedEffect(Unit) {
////        viewModelDACS3.getProductsFromFirestore(product)
//        Log.d("ScaffoldHome", "Product list updated: $sanPhamList")
//    }
////    DisposableEffect(viewModelDACS3) {
////        viewModelDACS3.addListener()
////        onDispose { viewModelDACS3.removeListener() }
////    }
//    Scaffold(
//        topBar = {
//            AppBar(
//                navController = navHostController,
//                isVisible = topBarVisibilityState.value,
//                searchCharSequence = {},
//                onAccountIconClick = {
//                    navHostController.navigate(ScreenDACS3.Login.route)
//                },
//                onCartIconClick = {
//                    navHostController.navigate(ScreenDACS3.CartScreen.route)
//                }
//            )
//        },
//        bottomBar = {
////            BottomAppBar()
//
//        },
//    )
//    { innerPadding ->
//        Column(
//            modifier = Modifier
//                .padding(innerPadding)
////                .verticalScroll(rememberScrollState())
//                .fillMaxSize(),
//        ) {
//            Text(
//                text = stringResource(R.string.danhmucsanpham),
//                modifier = Modifier
//                    .padding(10.dp)
//            )
//            LazyRow(
//                modifier = Modifier
//                    .padding(2.dp)
//                    .background(Color.White)
//            ) {
////                item {
////                    CardDanhMucTrangChu(urlAnh)
////                }
////                items(urlAnh.size) { item ->
////                    CardDanhMucTrangChu(urlAnh = urlAnh[item])
////                }
//                items(sanPhamList) { item ->
//                    CategoryCard(
//                        urlAnh = item.image,
//                        onSelected = {
//                            navHostController.navigate(ScreenDACS3.EcommerceHomeScreen.route)
//                        }
//                    )
//                }
//
//            }
//            Text(
//                text = stringResource(R.string.danhsachsanphamnoibat),
//                modifier = Modifier
//                    .padding(10.dp)
//            )
//            LazyVerticalGrid(
//                state = verticalScrollState,
//                columns = GridCells.Fixed(2),
//                modifier = Modifier.padding(10.dp)
//            ) {
//                items(sanPhamList) { item ->
//                    ProductCard(
//                        url = item.copy(),
//                        navController = navHostController,
//                        onSelected = {
//                            navHostController.navigate("${ScreenDACS3.ProductScreen.route}/${item.id}")
//                        }
//                    )
//                }
////                items(urlAnhDS.size) { item ->
////                    CardSanPham(
////                        url = urlAnhDS[item],
////                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
////                        modifier = Modifier
////                            .padding(8.dp)
////                            .clickable { },
////
////                    )
////                }
//
//            }
//
//        }
//
//    }
//}
//
//@Composable
//fun BottomAppBar() {
//    BottomAppBar(
//        containerColor = Color.White,
//        contentColor = MaterialTheme.colorScheme.primary,
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        Button(
//            onClick = { /*TODO*/ }, modifier = Modifier
//                .weight(1f)
//                .padding(2.dp)
//        ) {
//            Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
//        }
//        Button(
//            onClick = { }, modifier = Modifier
//                .weight(1f)
//                .padding(2.dp)
//        ) {
//            Icon(imageVector = Icons.Default.List, contentDescription = "List")
//        }
//        Button(
//            onClick = { /*TODO*/ }, modifier = Modifier
//                .weight(1f)
//                .padding(2.dp)
//        ) {
//            Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Cart")
//        }
//        Button(
//            onClick = { /*TODO*/ }, modifier = Modifier
//                .weight(1f)
//                .padding(2.dp)
//        ) {
//            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Account")
//        }
//
//    }
//}
//
//@Composable
//fun CategoryCard(
//    urlAnh: String,
//    onSelected: () -> Unit,
//) {
//    Card(
//        modifier = Modifier
//            .padding(4.dp)
//            .clickable(onClick = onSelected),
//        elevation = CardDefaults
//            .cardElevation(defaultElevation = 10.dp),
//        colors = CardDefaults.cardColors(Color.White)
//
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(5.dp)
//                .sizeIn(minHeight = 72.dp)
//
//        ) {
//            Box(
//                modifier = Modifier
//                    .size(72.dp)
//                    .clip(RoundedCornerShape(8.dp))
//
//            ) {
//                AsyncImage(
//                    model = urlAnh,
//                    contentDescription = "",
//                    alignment = Alignment.Center,
//                    contentScale = ContentScale.FillBounds
//
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun ProductCard(
//    url: ProductList,
//    navController: NavHostController,
//    onSelected: () -> Unit,
//) {
//    Card(
//        modifier = Modifier
//            .padding(8.dp)
//            .clickable(onClick = onSelected)
//            .background(Color.White),
//        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
//        colors = CardDefaults.cardColors(Color.White)
//    ) {
//        Column(
//            modifier = Modifier
//                .padding(4.dp)
//                .fillMaxSize()
//                .sizeIn(minHeight = 100.dp)
//                .align(Alignment.CenterHorizontally)
//        ) {
//            Box(
//                modifier = Modifier
//                    .size(160.dp)
//                    .clip(RoundedCornerShape(8.dp))
//                    .align(Alignment.CenterHorizontally)
//            ) {
//                Column {
//                    AsyncImage(
//                        model = url.image,
//                        contentDescription = "",
//                        alignment = Alignment.Center,
//                        contentScale = ContentScale.FillBounds,
//                    )
//                    Spacer(modifier = Modifier.height(5.dp))
//
//                }
//            }
//            Box(
//                modifier = Modifier
//                    .padding(start = 6.dp, top = 8.dp, bottom = 6.dp, end = 6.dp),
//            ) {
//                Text(
////                text = LocalContext.current.getString(item.ten),
//                    text = url.name,
//                    style = TextStyle(
//                        fontSize = 20.sp,
//                        fontWeight = FontWeight.W400,
//                    ),
//                )
//            }
//
//        }
//    }
//}
//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AppBar(
//    navController: NavHostController,
//    isVisible: Boolean,
//    searchCharSequence: (String) -> Unit,
//    onAccountIconClick: () -> Unit,
//    onCartIconClick: () -> Unit
//) {
//    var typedText by remember {
//        mutableStateOf(TextFieldValue())
//    }
//    if (isVisible) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 15.dp, end = 15.dp, top = 30.dp, bottom = 30.dp),
//            horizontalArrangement = Arrangement.spacedBy(5.dp)
//        ) {
//            TextField(
//                value = typedText,
//                onValueChange = { newText ->
//                    typedText = newText
//                    searchCharSequence(newText.text)
//                },
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
//
//                modifier = Modifier
//                    .background(
//                        color = Color.LightGray,
//                        shape = RoundedCornerShape(20.dp)
//                    )
//                    .weight(1f),
//
//                )
//
//            Box(
//                modifier = Modifier
//                    .size(48.dp)
//                    .clip(CircleShape)
//                    .background(Color.White)
//                    .clickable {
//                        onCartIconClick()
//                    },
//                contentAlignment = Alignment.Center
//            ) {
//                Image(
//                    imageVector = Icons.Default.ShoppingCart,
//                    contentDescription = "Cart Icon"
//                )
//            }
//            ConstraintLayout() {
//                val (notification, notificationCounter) = createRefs()
//
//                Box(
//                    modifier = Modifier
//                        .size(48.dp)
//                        .clip(CircleShape)
//                        .background(Color.White)
//                        .constrainAs(notification) {}
//                        .clickable {
//                            onAccountIconClick()
//                        },
//
//                    contentAlignment = Alignment.Center
//                ) {
//                    Image(
//                        imageVector = Icons.Default.AccountCircle,
//                        contentDescription = "Account Icon"
//                    )
//
//                }
//                //notification count
////                Box(
////                    modifier = Modifier
////                        .size(20.dp)
////                        .background(color = Color.Red, shape = CircleShape)
////                        .padding(3.dp)
////                        .constrainAs(notificationCounter) {
////                            top.linkTo(notification.top)
////                            end.linkTo(notification.end)
////                        },
////                    contentAlignment = Alignment.Center
////                ) {
////                    Text(text = "3", fontSize = 11.sp, color = Color.White)
////                }
//
//            }
//
//        }
//    }
//}
//
//@Preview(
//    showSystemUi = true,
//    showBackground = true,
//
//    )
//@Composable
//fun TrangChuPreview() {
//    DoAnCoSo3Theme {
////        HomeScreen()
//        val navController = rememberNavController()
////        ProductCard(url = , navController)
//
//        val viewModelDACS3 = ViewModelDACS3()
//        ScaffoldHome(viewModelDACS3, navController)
//    }
//
//}
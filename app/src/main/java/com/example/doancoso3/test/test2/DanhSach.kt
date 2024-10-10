package com.example.doancoso3.test.test2//package com.example.doancoso3.ui.screen
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material.icons.filled.Search
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.rememberNavController
//import coil.compose.rememberImagePainter
//import com.example.doancoso3.R
//import com.example.doancoso3.test.data.ProductList
//import com.example.doancoso3.ui.dacs3.viewmodel.ViewModelDACS3
//import com.example.doancoso3.ui.navigation.ScreenDACS3
//import com.example.doancoso3.ui.theme.DoAnCoSo3Theme
//
//
//val searchText = mutableStateOf("")
//
//@Composable
//fun EcommerceHomeScreen(
//    navController: NavHostController,
//    viewModelDACS3: ViewModelDACS3,
////    id: Int
//) {
//    val sanPhamList by viewModelDACS3.product.collectAsState()
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//            .padding(horizontal = 16.dp)
//    ) {
//        TopBar(navController)
//        TitleSection()
//        Spacer(modifier = Modifier.height(16.dp))
//        SearchSection()
//        Spacer(modifier = Modifier.height(24.dp))
//        ProductsSection(navController, sanPhamList)
//    }
//}
//
//@Composable
//fun TopBar(navController: NavHostController) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(60.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Icon(
//            imageVector = Icons.Default.ArrowBack,
//            contentDescription = stringResource(R.string.back_button),
//            Modifier.clickable { navController.navigateUp() }
//        )
//    }
//}
//
//@Composable
//fun TitleSection() {
//    Column(
//        modifier = Modifier.padding(horizontal = 8.dp)
//    ) {
//        Text(
//            text = "Danh Sách Sản Phẩm",
//            style = MaterialTheme.typography.headlineSmall,
//            fontWeight = FontWeight.Bold
//        )
//        Text(
//            text = "",
//            color = Color(0xFFCDCDCD)
//        )
//    }
//}
//
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
//
//@Composable
//fun ProductsSection(navController: NavHostController, sanPhamList: List<ProductList>) {
//    LazyColumn {
//        items(sanPhamList) { product ->
//            ProductItem(
//                product
//            ) {
//                navController.navigate(ScreenDACS3.ProductScreen.route + "/${product.id}")
//            }
//            Spacer(modifier = Modifier.height(16.dp))
//        }
//    }
//}
//
//@Composable
//fun ProductItem(
//    product: ProductList,
//    onItemClick: () -> Unit
//) {
//    Card(
//        elevation = CardDefaults.cardElevation(10.dp)
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(180.dp)
//                .background(Color.White)
//                .clickable(onClick = onItemClick),
//            contentAlignment = Alignment.Center,
//
//            ) {
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 16.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//
//                Image(
//                    painter = rememberImagePainter(product.image),
//                    contentDescription = null,
//                    modifier = Modifier.fillMaxWidth(0.4f)
//                )
//
//                Spacer(modifier = Modifier.width(16.dp))
//
//                Column {
//                    Text(product.name, style = MaterialTheme.typography.headlineSmall)
//                    Spacer(modifier = Modifier.height(8.dp))
//                    Text(
//                        text = "Mô tả",
//                        color = Color(0xFFB1B1B1)
//                    )
//                    Spacer(modifier = Modifier.height(16.dp))
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Text(text = "$3000", fontWeight = FontWeight.Bold, fontSize = 16.sp)
//                        Spacer(modifier = Modifier.width(16.dp))
//                        Text(
//                            text = "Buy",
//                            fontSize = 14.sp,
//                            modifier = Modifier
//                                .background(Color(0xCE313131), shape = CircleShape)
//                                .padding(top = 4.dp, bottom = 4.dp, start = 12.dp, end = 12.dp),
//                            color = textColor
//                        )
//                    }
//                }
//
//            }
//        }
//    }
//
//}
//
//@Preview(
//    showSystemUi = true,
//    showBackground = true
//)
//@Composable
//fun DanhMuc() {
//    DoAnCoSo3Theme() {
////        DanhSachScreen(DanhSach().load())
//        val navController = rememberNavController()
////        EcommerceHomeScreen(navController)
//    }
//
//}

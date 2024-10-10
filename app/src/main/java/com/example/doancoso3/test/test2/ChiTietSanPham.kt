package com.example.doancoso3.test.test2//package com.example.doancoso3.ui.screen
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material.icons.filled.Favorite
//import androidx.compose.material.icons.filled.ShoppingCart
//import androidx.compose.material.icons.filled.Star
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Alignment.Companion.Center
//import androidx.compose.ui.Alignment.Companion.End
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import coil.compose.rememberAsyncImagePainter
//import com.example.doancoso3.ui.dacs3.viewmodel.ViewModelDACS3
//import com.example.doancoso3.test.data.size
//import com.example.doancoso3.ui.navigation.ScreenDACS3
//import com.example.doancoso3.ui.theme.DoAnCoSo3Theme
//
//
//val textColor = Color(0xFFB1B1B1)
//
//@Composable
//fun ProductScreen(
//    viewModelDACS3: ViewModelDACS3,
//    navController: NavHostController,
//    id: Int
//) {
//    val context = LocalContext.current
//    val sanPhamList by viewModelDACS3.product.collectAsState()
//    val product = sanPhamList[id]
//
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//            .padding(bottom = 16.dp),
//        verticalArrangement = Arrangement.SpaceBetween
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//        ) {
//            ImageSection(
//                product.image,
//                Color.White,
//                Modifier.clickable { navController.navigateUp() }
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//            AboutSection(
//                product.name,
//                productDescription = "Mô tả",
////                rating = product.rating,
//                price = "$4000"
//            )
//            Spacer(modifier = Modifier.height(24.dp))
//            SizeSection()
//            Spacer(modifier = Modifier.height(24.dp))
//            DescriptionSection("Amet minim mollit non deserunt ullamco est sit aliqua dolor do amet sint. Velit officia consequat duis enim velit mollit. Exercitation veniam consequat sunt nostrud amet.")
//        }
//        AddToCartSection(
//            modifier = Modifier.align(End),
//            color = Color.White,
//            onSelected = {
//                viewModelDACS3.addCartItem(
//                    id = product.id,
//                    ten = product.name,
//                    anh = product.image,
//                    gia = product.gia,
//                    soluong = product.soluong
//                )
//                navController.navigate(ScreenDACS3.CartScreen.route)
//            }
//        )
//    }
//}
//
//@Composable
//fun ImageSection(
//    image: String,
//    color: Color,
//    modifier: Modifier
//) {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .fillMaxHeight(0.3f)
//            .background(color, shape = RoundedCornerShape(24.dp))
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Icon(
//                imageVector = Icons.Default.ArrowBack,
//                contentDescription = null,
//                modifier = modifier
//            )
//            HeartSection()
//        }
//
//        Image(
//            painter = rememberAsyncImagePainter(model = image),
//            contentDescription = null,
//            modifier = Modifier
//                .fillMaxWidth(0.7f)
//                .align(Center),
//            contentScale = ContentScale.Inside
//        )
//    }
//}
//
//@Composable
//fun AboutSection(
//    name: String,
//    productDescription: String,
////    rating: String,
//    price: String
//) {
//    Column(
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        Text(text = name, style = MaterialTheme.typography.bodyLarge)
//        Spacer(modifier = Modifier.height(4.dp))
//        Text(text = productDescription, color = textColor)
//        Spacer(modifier = Modifier.height(4.dp))
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(end = 16.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//
//            Row(
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Star,
//                    contentDescription = null,
//                    tint = Color(0xFFFFC000)
//                )
//                Spacer(modifier = Modifier.width(4.dp))
//                Text(text = "4.0")
//                Spacer(modifier = Modifier.width(4.dp))
//                Text(text = "(Avg. Rating)")
//            }
//            Text(
//                text = price,
//                fontSize = 16.sp,
//                fontWeight = FontWeight.Bold,
//            )
//        }
//    }
//}
//
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
//
//@Composable
//fun SizeItem(
//    size: String
//) {
//    Box(
//        modifier = Modifier
//            .size(60.dp)
//            .border(1.dp, textColor, shape = CircleShape),
//        contentAlignment = Center
//    ) {
//        Text(text = size, fontSize = 18.sp, color = textColor)
//    }
//}
//
//@Composable
//fun DescriptionSection(
//    description: String
//) {
//    Column {
//        Text(text = "Description", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
//        Spacer(modifier = Modifier.height(12.dp))
//        Text(
//            text = description,
//            color = textColor
//        )
//    }
//}
//
//@Composable
//fun AddToCartSection(modifier: Modifier, color: Color, onSelected: () -> Unit) {
//    Box(
//        modifier = modifier
//            .size(120.dp, 60.dp)
//            .background(
//                color = Color.White,
//                shape = RoundedCornerShape(
//                    topStart = 30.dp,
//                    bottomStart = 30.dp,
//                    bottomEnd = 0.dp,
//                    topEnd = 0.dp
//                )
//            )
//            .clickable(onClick = onSelected),
//        contentAlignment = Center
//    ) {
//        Row(
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Icon(
//                imageVector = Icons.Default.ShoppingCart,
//                contentDescription = null
//            )
//            Spacer(modifier = Modifier.width(16.dp))
//            Text(text = "Add", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
//        }
//    }
//}
//
//
//@Composable
//fun HeartSection() {
//    Box(
//        modifier = Modifier
//            .size(36.dp)
//            .background(Color.White, shape = CircleShape),
//        contentAlignment = Center
//    ) {
//        Icon(
//            imageVector = Icons.Default.Favorite,
//            contentDescription = null,
//            tint = Color.Red,
//            modifier = Modifier.size(18.dp)
//        )
//    }
//}
//
//@Preview(
//    showBackground = true,
//    showSystemUi = true
//)
//@Composable
//fun ChiTiet() {
//    DoAnCoSo3Theme {
////        val navController = rememberNavController()
////        val viewModelDACS3 = ViewModelDACS3()
////        ProductScreen(viewModelDACS3, navController,1)
//    }
//}
//

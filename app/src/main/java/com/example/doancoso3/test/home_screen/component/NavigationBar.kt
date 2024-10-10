//package com.example.doancoso3.test.home_screen.component
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.draw.shadow
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import androidx.navigation.compose.currentBackStackEntryAsState
//import com.example.doancoso3.test.home_screen.BottomNavItem
//
//@Composable
//fun NavigationBar(
//    navController: NavController,
//    isVisible: (Boolean) -> Unit,
//) {
//    val navItemList = listOf(
//        BottomNavItem.HomeNav,
//        BottomNavItem.FavouriteNav,
//        BottomNavItem.ChatNav,
//        BottomNavItem.ProfileNav,
//    )
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    var bottomNavVisibility by remember { mutableStateOf(true) }
//
//    if (bottomNavVisibility) {
//        NavigationBar(
//            containerColor = Color.White,
//            modifier = Modifier
//                .background(color = Color.White)
//                .shadow(
//                    shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
//                    elevation = 12.dp,
//                )
//                .clip(RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp))
//                .height(56.dp) // Ensure a fixed height for the navigation bar
//        ) {
//            navItemList.forEach { screen ->
//                NavigationBarItem(
//                    selected = navBackStackEntry?.destination?.route == screen.route,
//                    icon = {
//                        Icon(
//                            imageVector = screen.icon,
//                            contentDescription = null,
//                            tint = if (navBackStackEntry?.destination?.route == screen.route) MaterialTheme.colorScheme.primary else LocalContentColor.current,
//                        )
//                    },
//                    onClick = {
//                        navController.navigate(screen.route) {
//                            // Avoid multiple copies of the same destination
//                            popUpTo(navController.graph.startDestinationId) {
//                                saveState = true
//                            }
//                            launchSingleTop = true
//                            restoreState = true
//                        }
//                    },
//                    colors = NavigationBarItemDefaults.colors(
//                        selectedIconColor = MaterialTheme.colorScheme.primary,
//                        unselectedIconColor = LocalContentColor.current,
//                        selectedTextColor = MaterialTheme.colorScheme.primary,
//                        unselectedTextColor = LocalContentColor.current,
//                        indicatorColor = Color.Transparent
//                    )
//                )
//            }
//        }
//    }
//
//    // Hide or show the bottom navigation bar based on the current route
////    when (navBackStackEntry?.destination?.route) {
////        ShopHomeScreen.DashboardScreen.route -> {
////            bottomNavVisibility = true
////            isVisible(true)
////        }
////        DetailScreen.ProductDetailScreen.route + "/{${Constrains.PRODUCT_ID_PARAM}}" -> {
////            bottomNavVisibility = false
////            isVisible(false)
////        }
////        DetailScreen.CartScreen.route -> {
////            bottomNavVisibility = false
////            isVisible(false)
////        }
////        DetailScreen.NotificationScreen.route -> {
////            bottomNavVisibility = false
////            isVisible(false)
////        }
////        else -> {
////            bottomNavVisibility = true
////            isVisible(false)
////        }
////    }
//}

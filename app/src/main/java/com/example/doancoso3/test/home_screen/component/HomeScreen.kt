//package com.example.doancoso3.test.home_screen.component
//
//import android.annotation.SuppressLint
//import androidx.compose.foundation.ScrollState
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.rememberNavController
//import com.example.doancoso3.ui.theme.DoAnCoSo3Theme
//
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Composable
//fun HomeScreen(
//    navController: NavHostController = rememberNavController(),
//    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
//    boxScrollState: ScrollState = rememberScrollState(),
//) {
//    // State for the visibility of the top bar
//    val topBarVisibilityState = remember { mutableStateOf(true) }
//
//    Scaffold(
//        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
//        topBar = {
//            AppBar(
//                navController = navController,
//                isVisible = topBarVisibilityState.value,
//                searchCharSequence = {
//                    // Handle search character sequence
//                },
//                onCartIconClick = {
////                    navController.navigate(DetailScreen.CartScreen.route)
//                },
//                onNotificationIconClick = {
////                    navController.navigate(DetailScreen.NotificationScreen.route)
//                }
//            )
//        },
//        bottomBar = {
//            NavigationBar(navController = navController) { isVisible ->
//                topBarVisibilityState.value = isVisible
//            }
//        }
//    ) { padding ->
//        Box(
//            modifier = Modifier
//                .padding(padding)
//                .verticalScroll(boxScrollState)
//        ) {
////            HomeNavGraph(navHostController = navController)
//        }
//    }
//}
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun Hahaha() {
//    DoAnCoSo3Theme {
//        HomeScreen()
//    }
//}
//

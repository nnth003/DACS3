//package com.example.doancoso3.test.mainscreen
//
//
//import android.widget.Toast
////import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.platform.LocalContext
//import androidx.navigation.NavHostController
//import androidx.navigation.NavType
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.navArgument
//
//@Composable
//fun Navigation(navHostController: NavHostController) {
//    val context = LocalContext.current
//    NavHost(
//        navController = navHostController,
//        startDestination = Screen.EcommerceHomeScreen.route
//    ) {
//        composable(route = Screen.ScaffoldHome.route) {
////            ScaffoldHome(
////                duLieu = Data().load(),
////                onDanhMucButton = navHostController,
////                route = Screen.EcommerceHomeScreen.route
////            )
//        }
//        composable(route = Screen.EcommerceHomeScreen.route) {
////            EcommerceHomeScreen(navController = navHostController)
//        }
//        composable(
//            route = Screen.ProductScreen.route + "/{productsId}",
//            arguments = listOf(
//                navArgument("productsId") {
//                    type = NavType.IntType
//                }
//            )
//        ) {
//
//            val id = it.arguments?.getInt("productsId")
//            if (id != null) {
////                ProductScreen(navController = navHostController, id = id)
//            } else {
//
//                Toast.makeText(context, "Error ID", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//}
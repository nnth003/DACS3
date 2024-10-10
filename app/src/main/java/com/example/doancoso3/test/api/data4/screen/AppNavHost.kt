//package com.example.doancoso3.test.api.data4.screen
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import com.example.doancoso3.ui.api.data4.main.ItemViewModel
//
//@Composable
//fun AppNavHost(navController: NavHostController, viewModel: ItemViewModel) {
//    NavHost(navController, startDestination = "home") {
//        composable("home") { HomeScreen(navController) }
//        composable("add") { AddScreen(navController, viewModel) }
//        composable("edit") { EditScreen(navController, viewModel) }
//        composable("delete") { DeleteScreen(navController, viewModel) }
//        composable("display") { DisplayScreen(navController, viewModel) }
////        composable("detail/{itemId}") { backStackEntry ->
////            val itemId = backStackEntry.arguments?.getString("itemId")?.toInt() ?: 0
////            DetailScreen(navController, viewModel, itemId)
////        }
//    }
//}

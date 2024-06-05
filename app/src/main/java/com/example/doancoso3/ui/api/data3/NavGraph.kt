package com.example.doancoso3.ui.api.data3

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "user_list") {
        composable("user_list") { UserListScreen(navController) }
        composable("add_user") { AddUserScreen(navController) }
        composable("edit_user/{userId}") { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId") ?: ""
            EditUserScreen(navController, userId)
        }
        composable("delete_user/{userId}") { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId") ?: ""
            DeleteUserScreen(navController, userId)
        }
    }
}
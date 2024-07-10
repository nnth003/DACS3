package com.example.doancoso3.ui.api.data3

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavType
import androidx.navigation.navArgument

@Composable
fun NavGraph(navController: NavHostController, viewModel: UserViewModel) {
    NavHost(navController = navController, startDestination = "user_list") {
        composable("user_list") { UserListScreen(navController, viewModel) }
        composable("add_user") { AddUserScreen(navController) }
        composable(
            route = "edit_user/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.IntType
                }
            )
        ) {
            val userId = it.arguments?.getInt("id")
            if (userId != null) {
                EditUserScreen(navController, userId, viewModel)
            }
        }
        composable(
            route ="delete_user/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.IntType
                }
            )
        ) {
            val userId = it.arguments?.getInt("id")
            if (userId != null) {
                DeleteUserScreen(navController, userId, viewModel)
            }
        }
    }
}
package com.example.doancoso3.ui.api.data3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DeleteUserScreen(navController: NavController, userId: String, vm: UserViewModel = viewModel()) {
    val user = vm.getUserById(userId)

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Are you sure you want to delete ${user?.name}?")

        Button(onClick = {
            // Delete User
            vm.deleteUser(userId)
            navController.navigate("user_list")
        }) {
            Text("Delete User")
        }
    }
}

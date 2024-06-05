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
fun EditUserScreen(navController: NavController, userId: String, vm: UserViewModel = viewModel()) {
    val user = vm.getUserById(userId)

    var name by remember { mutableStateOf(user?.name ?: "") }
    var age by remember { mutableStateOf(user?.age ?: "") }
    var city by remember { mutableStateOf(user?.city ?: "") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
        TextField(value = age, onValueChange = { age = it }, label = { Text("Age") })
        TextField(value = city, onValueChange = { city = it }, label = { Text("City") })

        Button(onClick = {
            // Update User
            vm.updateUser(UserItem(id = userId, name = name, age = age, city = city))
            navController.navigate("user_list")
        }) {
            Text("Update User")
        }
    }
}

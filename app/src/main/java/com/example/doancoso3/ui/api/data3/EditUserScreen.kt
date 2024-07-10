package com.example.doancoso3.ui.api.data3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun EditUserScreen(
    navController: NavController,
    userId: Int,
    vm: UserViewModel,
) {
//    LaunchedEffect(Unit) {
//        vm.getUserById(userId)
//    }

    val userList by vm.user1.collectAsState()
    val user = userList.find { it.id == userId }

    var name by remember { mutableStateOf(user?.name ?: "") }
    var description by remember { mutableStateOf(user?.description ?: "") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
        TextField(value = description, onValueChange = { description = it }, label = { Text("Description") })

        Button(onClick = {
            // Update User
            vm.updateUser(navController,userId, name, description)
            navController.navigate("user_list")
        }) {
            Text("Update User")
        }
    }
}

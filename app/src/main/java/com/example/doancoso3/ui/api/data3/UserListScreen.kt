package com.example.doancoso3.ui.api.data3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListScreen(navController: NavController, vm: UserViewModel = viewModel()) {
    LaunchedEffect(Unit, block = {
        vm.getUserList()
    })

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("User List") },
                actions = {
                    Button(onClick = { navController.navigate("add_user") }) {
                        Text("Add User")
                    }
                }
            )
        },
        content = { innerPadding ->
            if (vm.errorMessage.isEmpty()) {
                LazyColumn(modifier = Modifier.padding(innerPadding)) {
                    items(vm.todoList) { user ->
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(user.name)
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Button(onClick = { navController.navigate("edit_user/${user.id}") }) {
                                    Text("Edit")
                                }
                                Button(onClick = { navController.navigate("delete_user/${user.id}") }) {
                                    Text("Delete")
                                }
                            }
                            Divider()
                        }
                    }
                }
            } else {
                Text(vm.errorMessage)
            }
        }
    )
}

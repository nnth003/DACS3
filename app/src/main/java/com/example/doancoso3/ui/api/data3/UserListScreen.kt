package com.example.doancoso3.ui.api.data3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListScreen(
    navController: NavHostController,
    viewModel: UserViewModel
) {
    val userList by viewModel.user1.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getUserList()
    }

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
            if (viewModel.errorMessage.isEmpty()) {
                LazyColumn(modifier = Modifier.padding(innerPadding)) {
                    items(userList) { user ->
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(user.id.toString())
                            Text(user.name)
                            Text(user.description)
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
                            Box(
                                modifier = Modifier
                                    .size(72.dp)
                                    .clip(RoundedCornerShape(8.dp))

                            ) {
                                AsyncImage(
                                    model = "https://apidacs3.000webhostapp.com/img/${user.anh}",
                                    contentDescription = "",
                                    alignment = Alignment.Center,
                                    contentScale = ContentScale.FillBounds

                                )
                            }
                        }
                    }
                }
            } else {
                Text(viewModel.errorMessage)
            }
        }
    )
}

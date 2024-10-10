//package com.example.doancoso3.test.api.data3
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavHostController
//
//@Composable
//fun DeleteUserScreen(
//    navController: NavController,
//    userId: Int,
//    vm: UserViewModel,
//) {
//    val userList by vm.user1.collectAsState()
//    val user = userList.find { it.id == userId }
//
//    Column(modifier = Modifier.padding(16.dp)) {
//        if (user != null) {
//            Text("Are you sure you want to delete ${user.name}?")
//        }
//
//        Button(onClick = {
//            // Delete User
//            vm.deleteUser(userId)
//            navController.navigate("user_list")
//        }) {
//            Text("Delete User")
//        }
//    }
//}

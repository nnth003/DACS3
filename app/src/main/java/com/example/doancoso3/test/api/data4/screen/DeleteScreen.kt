//package com.example.doancoso3.test.api.data4.screen
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavHostController
//import com.example.doancoso3.ui.api.data4.main.ItemViewModel
//
//@Composable
//fun DeleteScreen(navController: NavHostController, viewModel: ItemViewModel) {
//    var id by remember { mutableStateOf("") }
//
//    Column(modifier = Modifier.padding(16.dp)) {
//        TextField(value = id, onValueChange = { id = it }, label = { Text("ID") })
//        Button(onClick = {
//            viewModel.deleteItem(id.toInt())
////            navController.popBackStack()
//        }) {
//            Text("Xóa")
//        }
//    }
//}

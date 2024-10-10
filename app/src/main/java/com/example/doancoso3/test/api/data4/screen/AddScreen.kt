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
//import com.example.doancoso3.ui.api.data4.main.Item
//import com.example.doancoso3.ui.api.data4.main.ItemViewModel
//
//
//@Composable
//fun AddScreen(navController: NavHostController, viewModel: ItemViewModel) {
//    var name by remember { mutableStateOf("") }
//    var description by remember { mutableStateOf("") }
//
//    Column(modifier = Modifier.padding(16.dp)) {
//        TextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
//        TextField(
//            value = description,
//            onValueChange = { description = it },
//            label = { Text("Description") })
//        Button(onClick = {
//            val newItem = Item(0, name, description)
//            viewModel.addItem(name, description)
//            navController.popBackStack()
//        }) {
//            Text("Thêm")
//        }
//    }
//}

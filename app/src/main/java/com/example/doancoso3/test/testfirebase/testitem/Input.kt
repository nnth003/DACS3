//package com.example.doancoso3.test.testfirebase.testitem
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavController
//
//@Composable
//fun InputScreen(navController: NavController) {
//    val viewModel: MyViewModel = viewModel()
//    var inputText by remember { mutableStateOf("") }
//    Column(
//        modifier = Modifier.fillMaxSize().padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        TextField(value = inputText, onValueChange = { inputText = it }, label = { Text("Enter data") })
//        Button(onClick = {
//            viewModel.addData(inputText)
//            navController.navigate("list_screen")
//        }) {
//            Text("Submit")
//        }
//    }
//}

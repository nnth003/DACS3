package com.example.doancoso3.ui.testfirebase.testitem

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun EditScreen(navController: NavController, itemId: String) {
    val viewModel: MyViewModel = viewModel()
    val item by viewModel.getItem(itemId).collectAsState(initial = null)
    var updatedText by remember { mutableStateOf("") }

    item?.let {
//        updatedText = it.name

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            TextField(
                value = updatedText,
                onValueChange = { updatedText = it },
                label = { Text("Edit data") })
            Button(onClick = {
                viewModel.updateData(itemId, updatedText)
                navController.navigate("list_screen")
            }) {
                Text("Update")
            }
            Button(onClick = {
                viewModel.deleteData(itemId)
                navController.navigate("list_screen")
            }) {
                Text("Delete")
            }
        }
    }
}

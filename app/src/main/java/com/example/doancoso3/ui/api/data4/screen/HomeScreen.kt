package com.example.doancoso3.ui.api.data4.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = { navController.navigate("add") }) {
            Text("Thêm")
        }
        Button(onClick = { navController.navigate("edit") }) {
            Text("Sửa")
        }
        Button(onClick = { navController.navigate("delete") }) {
            Text("Xóa")
        }
        Button(onClick = { navController.navigate("display") }) {
            Text("Hiển thị")
        }
    }
}

package com.example.doancoso3.ui.api.data4.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.doancoso3.ui.api.data4.main.ItemViewModel

@Composable
fun DisplayScreen(navController: NavHostController, viewModel: ItemViewModel) {
    val items by viewModel.items.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchItems()
    }

    Column(modifier = Modifier.padding(16.dp)) {
        items.forEach { item ->
            Row(modifier = Modifier.fillMaxWidth().clickable {
                navController.navigate("detail/${item.id}")
            }) {
                Text("${item.name}: ${item.description}")
            }
        }
    }
}

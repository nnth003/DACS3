package com.example.doancoso3.ui.testfirebase.testitem

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
fun ListScreen(navController: NavController) {
    val viewModel: MyViewModel = viewModel()
    val itemList by viewModel.items.collectAsState(initial = emptyList())

    LazyColumn {
        items(itemList) { item ->
            Text(
                text = item.name,
                modifier = Modifier.clickable { navController.navigate("detail_screen/${item.id}") }
                    .padding(16.dp)
            )
        }
    }
}


@Composable
fun ListItem(item: Item, onItemClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .clickable(onClick = { onItemClick(item.id) })
            .padding(16.dp)
    ) {
        Row {
            Text(text = item.name)
        }
        Row {
            Text(text = item.id)
        }

    }
}


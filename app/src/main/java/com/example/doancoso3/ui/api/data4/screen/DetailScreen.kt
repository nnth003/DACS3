package com.example.doancoso3.ui.api.data4.screen
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.doancoso3.ui.api.data4.main.ItemViewModel
//@Composable
//fun DetailScreen(navController: NavHostController, viewModel: ItemViewModel, itemId: Int) {
//    val item by viewModel.selectedItem.collectAsState()
//
//    LaunchedEffect(itemId) {
//        viewModel.fetchItemDetails(itemId)
//    }
//
//    item?.let {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Text("ID: ${it.id}")
//            Text("Name: ${it.name}")
//            Text("Description: ${it.description}")
//            Button(onClick = { navController.popBackStack() }) {
//                Text("Back")
//            }
//        }
//    } ?: run {
//        Text("Loading...")
//    }
//}

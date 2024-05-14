package com.example.doancoso3.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.doancoso3.ui.theme.DoAnCoSo3Theme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldList() {
    var presses by remember { mutableIntStateOf(0) }

//    Scaffold(
//        topBar = {
//
//            TopAppBar(
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = MaterialTheme.colorScheme.primaryContainer,
//                    titleContentColor = MaterialTheme.colorScheme.primary,
//                ),
//                title = {
//                    Text("Top app bar")
//                }
//            )
//        },
//        bottomBar = {
//            BottomAppBar(
//                containerColor = MaterialTheme.colorScheme.primaryContainer,
//                contentColor = MaterialTheme.colorScheme.primary,
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Button(onClick = { /*TODO*/ }, modifier = Modifier
//                    .weight(1f)
//                    .padding(2.dp)) {
//                    Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
//                }
//                Button(onClick = { /*TODO*/ }, modifier = Modifier
//                    .weight(1f)
//                    .padding(2.dp)) {
//                    Icon(imageVector = Icons.Default.List, contentDescription = "List")
//                }
//                Button(onClick = { /*TODO*/ }, modifier = Modifier
//                    .weight(1f)
//                    .padding(2.dp)) {
//                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Cart")
//                }
//                Button(onClick = { /*TODO*/ }, modifier = Modifier
//                    .weight(1f)
//                    .padding(2.dp)) {
//                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Account")
//                }
//
//            }
//        },
//        floatingActionButton = {
//            FloatingActionButton(onClick = { presses++ }) {
//                Icon(Icons.Default.Add, contentDescription = "Add")
//            }
//        }
//    ) { innerPadding ->
//        Column(
//            modifier = Modifier
//                .padding(innerPadding),
//            verticalArrangement = Arrangement.spacedBy(16.dp),
//        ) {
//            Text(
//                modifier = Modifier.padding(8.dp),
//                text =
//                """
//                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.
//
//                    It also contains some basic inner content, such as this text.
//
//                    You have pressed the floating action button $presses times.
//                """.trimIndent(),
//            )
//        }
//    }
    Text(text = "Danh Mục")
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun DanhMuc() {
    DoAnCoSo3Theme {
//        HomeScreen()
        ScaffoldList()
    }

}
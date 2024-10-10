//package com.example.doancoso3.test.api.data2
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.Checkbox
//import androidx.compose.material3.Divider
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.style.TextOverflow
//import androidx.compose.ui.unit.dp
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun TodoView(vm: TodoViewModel) {
//
//    LaunchedEffect(Unit, block = {
//        vm.getTodoList()
//    })
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Row {
//                        Text("Todos")
//                    }
//                })
//        },
//        content = {inner ->
//            if (vm.errorMessage.isEmpty()) {
//                Column(modifier = Modifier
//                    .padding(16.dp)
//                    .padding(inner)) {
//                    LazyColumn(modifier = Modifier.fillMaxHeight()) {
//                        items(vm.todoList) { todo ->
//                            Column {
//                                Row(
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .padding(16.dp),
//                                    horizontalArrangement = Arrangement.SpaceBetween
//                                ) {
//                                    Box(
//                                        modifier = Modifier
//                                            .fillMaxWidth()
//                                            .padding(0.dp, 0.dp, 16.dp, 0.dp)
//                                    ) {
//                                        Text(
//                                            todo.title,
//                                            maxLines = 1,
//                                            overflow = TextOverflow.Ellipsis
//                                        )
//                                    }
//                                    Spacer(modifier = Modifier.width(16.dp))
//                                    Checkbox(checked = todo.completed, onCheckedChange = null)
//                                }
//                                Divider()
//                            }
//                        }
//                    }
//                }
//            } else {
//                Text(vm.errorMessage)
//            }
//        }
//    )
//}
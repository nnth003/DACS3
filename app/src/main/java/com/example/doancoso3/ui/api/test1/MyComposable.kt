package com.example.doancoso3.ui.api.test1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MyComposable() {
    val userViewModel: UserViewModel = viewModel()
    var data by remember {
        mutableStateOf<List<UserItem>?>(null)
    }
    LaunchedEffect(Unit) {
//        userViewModel.getUsers()
        val response = apiService.getUsers()
        if (response.isSuccessful){
            data = response.body()
        }
    }
    if (data != null){
        DataDisplayList(data = data!!)
    }
//    val user by userViewModel.user.observeAsState(emptyList())
//    val loading by userViewModel.loading.observeAsState(false)
//    val error by userViewModel.error.observeAsState("")
//
//    if (loading) {
//        CircularProgressIndicator()
//    } else {
//        if (error.isNotEmpty()) {
//            Text(text = error, color = MaterialTheme.colorScheme.error)
//        }else{
//            DataDisplayList(user)
//        }
//    }
}


@Composable
fun DataDisplayList(data: List<UserItem>) {
    LazyColumn {
        items(data) { item ->
            DataDisplay(item)
        }
    }
}

@Composable
fun DataDisplay(data: UserItem) {
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Text(text = "ID: ${data.id}")
        Text(text = "Name: ${data.name}")
        Text(text = "Age: ${data.age}")
        Text(text = "City: ${data.city}")
    }
}

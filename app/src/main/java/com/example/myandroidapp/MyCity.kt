package com.example.myandroidapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun MyCityApp() {
    MyCity(modifier = Modifier)
}

@Composable
fun MyCity(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize().fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.image1),
                contentDescription = null
            )
            Text(text = "Category 1")
        }
    }
}
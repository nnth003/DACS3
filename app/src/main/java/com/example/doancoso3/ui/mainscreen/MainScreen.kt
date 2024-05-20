package com.example.doancoso3.ui.mainscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


data class ScreenName(
    val name: String,
    val route: String,
)

val screens = listOf(
    ScreenName("Home", Screen.ScaffoldHome.route),
    ScreenName("Products List", Screen.EcommerceHomeScreen.route),
    ScreenName("Products Detail", Screen.ProductScreen.route),

)
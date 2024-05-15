package com.example.doancoso3.ui.data

import androidx.compose.ui.graphics.Color

data class Product(
    val id: Int,
    val image: Int,
    val productName: String,
    val productDescription: String,
    val price: String,
    val color: Color,
    val rating: String
)

val size = (36..42).toList()

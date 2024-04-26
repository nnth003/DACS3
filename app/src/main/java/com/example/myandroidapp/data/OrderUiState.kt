package com.example.myandroidapp.data

data class OrderUiState(
    val quantity: Int = 0,
    val flavor: String = "",
    val date: String = "",
    val price: Any = "",
    val pickupOptions: List<String> = listOf()
)

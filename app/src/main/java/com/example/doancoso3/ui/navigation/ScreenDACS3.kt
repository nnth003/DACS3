package com.example.doancoso3.ui.navigation

sealed class ScreenDACS3(val route: String) {
    object ScaffoldHome: ScreenDACS3("home_screen")
    object EcommerceHomeScreen: ScreenDACS3("ecommerce_screen")
    object ProductScreen: ScreenDACS3("product_screen")
    object CartScreen: ScreenDACS3("cart_screen")
}
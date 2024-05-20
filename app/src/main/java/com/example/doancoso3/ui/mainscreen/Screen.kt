package com.example.doancoso3.ui.mainscreen

sealed class Screen(val route: String) {
    object ScaffoldHome: Screen("home_screen")
    object GioHangApp: Screen("cart_screen")
    object EcommerceHomeScreen: Screen("ecommerce_screen")
    object ProductScreen: Screen("product_screen")
}
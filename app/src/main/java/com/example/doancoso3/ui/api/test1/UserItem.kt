package com.example.doancoso3.ui.api.test1

data class UserItem(
    val age: String,
    val city: String,
    val id: String,
    val name: String
)

data class ApiResponse(
    val data: List<UserItem>,
    val status: Boolean
)
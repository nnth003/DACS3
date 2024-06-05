package com.example.doancoso3.ui.api.data3

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.doancoso3.ui.api.data3.APIService1.Companion.apiService1
import kotlinx.coroutines.launch


class UserViewModel : ViewModel() {
    private val _todoList = mutableStateListOf<UserItem>()
    var errorMessage: String by mutableStateOf("")
    val todoList: List<UserItem>
        get() = _todoList

    fun getUserList() {
        viewModelScope.launch {
            val apiService1 = APIService1.getInstance()
            try {
                _todoList.clear()
                _todoList.addAll(apiService1.getUsers())
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun getUserById(id: String): UserItem? {
        return _todoList.find { it.id == id }
    }

    fun addUser(user: UserItem) {
        viewModelScope.launch {
            val apiService1 = APIService1.getInstance()
            try {
                apiService1.createUser(user)
                getUserList()
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun updateUser(user: UserItem) {
        viewModelScope.launch {
            val apiService1 = APIService1.getInstance()
            try {
                apiService1.updateUser(user.id.toLong(), user)
                getUserList()
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun deleteUser(id: String) {
        viewModelScope.launch {
            val apiService1 = APIService1.getInstance()
            try {
                apiService1.deleteUser(id.toLong())
                getUserList()
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}
//package com.example.doancoso3.test.api.data3
//
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import androidx.navigation.NavController
//import androidx.navigation.compose.rememberNavController
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//
//class UserViewModel : ViewModel() {
//    private val _users = MutableStateFlow<List<UserItem>>(emptyList())
//    val user: StateFlow<List<UserItem>> = _users
//
//    private val _users1 = MutableStateFlow<List<Item>>(emptyList())
//    val user1: StateFlow<List<Item>> = _users1
//
//    var errorMessage: String by mutableStateOf("")
////    val navController by rememberNavController()
//    fun getUserList() {
//        viewModelScope.launch {
//            val apiService1 = APIService1.getInstance()
//            try {
//                _users1.value = apiService1.getUsers()
//            } catch (e: Exception) {
//                errorMessage = e.message.toString()
//            }
//        }
//    }
//
//    fun getUserById(id: Int) {
//        viewModelScope.launch {
//            val apiService1 = APIService1.getInstance()
//            try {
//                _users1.value = apiService1.getUserById(id)
//            } catch (e: Exception) {
//                errorMessage = e.message.toString()
//            }
//        }
//    }
//
//    fun addUser(name: String, description: String) {
//        viewModelScope.launch {
//            val apiService1 = APIService1.getInstance()
//            try {
//                apiService1.addUser(name, description)
//                getUserList()
//            } catch (e: Exception) {
//                errorMessage = e.message.toString()
//            }
//        }
//    }
//
//    fun updateUser(navController: NavController,userId: Int, name: String, description: String) {
//        viewModelScope.launch {
//            val apiService1 = APIService1.getInstance()
//            try {
//                apiService1.updateUser(userId, name, description)
//                getUserList()
//                navController.navigate("user_list")
//            } catch (e: Exception) {
//                errorMessage = e.message.toString()
//            }
//        }
//    }
//
//    fun deleteUser(id: Int) {
//        viewModelScope.launch {
//            val apiService1 = APIService1.getInstance()
//            try {
//                apiService1.deleteUser(id)
//                getUserList()
//            } catch (e: Exception) {
//                errorMessage = e.message.toString()
//            }
//        }
//    }
//}
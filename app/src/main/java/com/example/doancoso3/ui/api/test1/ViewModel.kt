package com.example.doancoso3.ui.api.test1

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel: ViewModel(){
//    private val repository = UserRepository()
//
//    private val _users = MutableLiveData<List<UserItem>>()
//    val user: LiveData<List<UserItem>> = _users
//
//    private val _loading = MutableLiveData<Boolean>()
//    val loading: LiveData<Boolean> = _loading
//
//    private val _error = MutableLiveData<String>()
//    val error: LiveData<String> = _error
//
//    fun getUsers(){
//        viewModelScope.launch {
//            _loading.value = true
//            try {
//                val response = repository.fetchUser()
//                if (response.status){
//                    _users.value = response.data
//                }else{
//                    _error.value = "No data available"
//                }
//            }catch (e: Exception){
//                _error.value = " Error fetching data: ${e.message}"
//            }
//            _loading.value = false
//        }
//    }
}
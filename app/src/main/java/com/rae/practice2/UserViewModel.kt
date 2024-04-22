package com.rae.practice2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rae.practice2.data.User
import com.rae.practice2.data.UserDatabase
import com.rae.practice2.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository):ViewModel(){
    //states
   val allUsers : Flow<List<User>> = userRepository.getAll
    init {

    }
    fun addUser(user: User){
        viewModelScope.launch (Dispatchers.IO){
            userRepository.addUser(user)
        }
    }
}
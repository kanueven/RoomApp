package com.rae.practice2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.rae.practice2.data.User
import com.rae.practice2.data.UserDatabase
import com.rae.practice2.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {
    private val userRepository: UserRepository
    private val getAll : LiveData<List<User>>
    //states
   init {
       val userDao = UserDatabase.getDatabase(application)
        userRepository= UserRepository(userDao)
        getAll = userRepository.getAll
   }
    fun addUser(user: User){
        viewModelScope.launch (Dispatchers.IO){
            userRepository.addUser(user)
        }
    }
}
package com.rae.practice2.data

import androidx.lifecycle.LiveData

class UserRepository(
    private val userDao: UserDao
) {
    val getAll: LiveData<List<User>> = userDao.getAll()

    suspend fun addUser(user: User){
        userDao.insert(user)
    }
}
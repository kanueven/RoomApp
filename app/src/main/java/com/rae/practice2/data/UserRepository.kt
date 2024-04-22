package com.rae.practice2.data


import kotlinx.coroutines.flow.Flow

class UserRepository(
    private val userDao: UserDao
) {
    val getAll: Flow<List<User>> = userDao.getAll()

    suspend fun addUser(user: User){
        userDao.insert(user)
    }
}
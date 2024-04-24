package com.rae.practice2

import com.rae.practice2.data.User

data class UserState(
    val user: List<User> = emptyList(),
    val firstName: String = "",
    val lastName: String = "",
    val age: String = "",
    val isAdding :Boolean = false,
)

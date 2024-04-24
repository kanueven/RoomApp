package com.rae.practice2.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insert(user: User)

    @Query("SELECT * FROM user_table")
    fun getAll() : Flow<List<User>>

    @Delete
   suspend fun deleteUser(user: User)
}
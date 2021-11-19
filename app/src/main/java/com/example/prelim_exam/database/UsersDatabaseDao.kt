package com.example.prelim_exam.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface UsersDatabaseDao {

    @Insert
    suspend fun insertUsers(users: Users) : Long

    @Query("SELECT * FROM users_table WHERE username LIKE :username")
    suspend fun getUsername(username: String): Users

}
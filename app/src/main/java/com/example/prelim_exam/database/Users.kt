package com.example.prelim_exam.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users_table")
data class Users(
    @PrimaryKey(autoGenerate = true)
    var userID: Int,

    @ColumnInfo(name = "username")
    var username: String,

    @ColumnInfo(name = "password")
    var password: String,

    @ColumnInfo(name = "email")
    var email: String,
)

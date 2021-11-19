package com.example.prelim_exam.database

class UsersRepository(private val dao: UsersDatabaseDao) {

    suspend fun insert(users: Users) : Long {
        return dao.insertUsers(users)
    }

    suspend fun getUserName(username: String):Users?{
        return dao.getUsername(username)
    }


}
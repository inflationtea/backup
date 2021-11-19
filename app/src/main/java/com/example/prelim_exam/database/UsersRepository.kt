package com.example.prelim_exam.database

class UsersRepository(private val dao: UsersDatabaseDao) {

    suspend fun insert(users: Users) : Long {
        return dao.insertUsers(users)
    }

    val users = dao.displayUsers()


}
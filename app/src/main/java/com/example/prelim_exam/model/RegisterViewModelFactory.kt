package com.example.prelim_exam.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.prelim_exam.database.UsersRepository
import java.lang.IllegalArgumentException

class RegisterViewModelFactory(
    private val repository: UsersRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RegisterViewModel::class.java)){
            return RegisterViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}
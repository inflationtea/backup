package com.example.prelim_exam.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prelim_exam.Event
import com.example.prelim_exam.database.Users
import com.example.prelim_exam.database.UsersRepository
import kotlinx.coroutines.launch



class RegisterViewModel(private val repository: UsersRepository) : ViewModel() {

    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val email = MutableLiveData<String>()

    private val statusMessage = MutableLiveData<Event<String>>()
    val message: LiveData<Event<String>>
        get() = statusMessage

    init{
        username.value = ""
        password.value = ""
        email.value = ""
    }

    fun register(){
        val usernameval = username.value!!
        val passwordval = password.value!!
        val emailval = email.value!!

        registerUsers(Users(0,usernameval,passwordval,emailval))
        username.value = ""
        password.value = ""
        email.value = ""
    }

    fun registerUsers(users:Users) = viewModelScope.launch {
        val newRowId = repository.insert(users)
        if (newRowId > -1){
            statusMessage.value = Event("User Registered Successfully $newRowId")
        }else{
            statusMessage.value = Event("Error Occurred")
        }
    }

}
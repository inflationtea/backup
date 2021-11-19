package com.example.prelim_exam.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.prelim_exam.database.InquiryRepository

class PostViewModelFactory(

    private val repository: InquiryRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PostViewModel::class.java)){
            return PostViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}
package com.example.prelim_exam.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.prelim_exam.database.InquiryRepository
import java.lang.IllegalArgumentException

class DisplayViewModelFactory(

    private val repository: InquiryRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DisplayViewModel::class.java)){
            return DisplayViewModel(repository) as T
        }
        throw  IllegalArgumentException("Unknwon View Model class")
    }
}
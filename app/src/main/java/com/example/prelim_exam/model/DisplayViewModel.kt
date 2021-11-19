package com.example.prelim_exam.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.prelim_exam.Event
import com.example.prelim_exam.database.InquiryRepository
import kotlinx.coroutines.flow.collect

class DisplayViewModel(private val repository: InquiryRepository) : ViewModel() {
    private val statusMessage = MutableLiveData<Event<String>>()
    val message: LiveData<Event<String>>
        get() = statusMessage

    fun getPostInquiry() = liveData{
        repository.inquiry.collect {
            emit(it)
        }
    }
}
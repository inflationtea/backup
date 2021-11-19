package com.example.prelim_exam.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prelim_exam.Event
import com.example.prelim_exam.database.Inquiry
import com.example.prelim_exam.database.InquiryRepository
import kotlinx.coroutines.launch

class PostViewModel(private val repository: InquiryRepository) : ViewModel() {


    val inqName = MutableLiveData<String>()
    val inqSubj = MutableLiveData<String>()
    val inqPost = MutableLiveData<String>()

    private val statusMessage = MutableLiveData<Event<String>>()
    val message: LiveData<Event<String>>
        get() = statusMessage

    init{

        inqName.value = ""
        inqSubj.value = ""
        inqPost.value = ""
    }

    fun post(){
        val inqNameval = inqName.value!!
        val inqSubjval = inqSubj.value!!
        val inqPostval = inqPost.value!!

        postInquiry(Inquiry(0, inqNameval,inqSubjval,inqPostval))
        inqName.value = ""
        inqSubj.value = ""
        inqPost.value = ""

    }
    fun postInquiry(inquiry: Inquiry) = viewModelScope.launch {
        val newRowId = repository.insert(inquiry)
        if (newRowId > -1) {
            statusMessage.value = Event("Post Sent $newRowId")
        } else {
            statusMessage.value = Event("Error Occurred")
        }
    }


}
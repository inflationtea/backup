package com.example.prelim_exam.database

class InquiryRepository(private val dao: InquiryDatabaseDao) {
    suspend fun insert(inquiry: Inquiry) : Long {
        return dao.insertInquiry(inquiry)
    }

    val inquiry = dao.displayInquiry()


}
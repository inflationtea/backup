package com.example.prelim_exam.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface InquiryDatabaseDao {

    @Insert
    suspend fun insertInquiry(inquiry: Inquiry) : Long

    @Query("SELECT * FROM inquiry_table ORDER BY inqID DESC")
    fun displayInquiry(): Flow<List<Inquiry>>

}
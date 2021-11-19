package com.example.prelim_exam.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "inquiry_table")
data class Inquiry(

    @PrimaryKey(autoGenerate = true)
    var inqID: Int,

    @ColumnInfo(name = "inqName")
    var inqName: String,

    @ColumnInfo(name = "inqSubj")
    var inqSubj: String,

    @ColumnInfo(name = "inqPost")
    var inqPost: String,
)

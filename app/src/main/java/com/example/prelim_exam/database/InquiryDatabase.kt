package com.example.prelim_exam.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Inquiry::class], version = 1, exportSchema = false)
abstract class InquiryDatabase : RoomDatabase() {

    abstract val inquiryDatabase: InquiryDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: InquiryDatabase? = null

        fun getInstance(context: Context): InquiryDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        InquiryDatabase::class.java,
                        "inquiry_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}
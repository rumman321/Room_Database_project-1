package com.example.room_database_2

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class StudentDatabase :RoomDatabase() {
    abstract fun studentDao():StudentDao

    companion object{
        @Volatile
        private var INSTANCE:StudentDatabase?=null

        fun getdatabase(context: Context):StudentDatabase{
            val tempinstance= INSTANCE
            if (tempinstance !=null) {
                return tempinstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StudentDatabase::class.java,
                    "student_database"

                ).build()
                INSTANCE=instance
                return instance
            }
        }

    }

}
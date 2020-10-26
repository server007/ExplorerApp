package com.example.dummyapibrowser.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dummyapibrowser.data.Employee

@Database(entities = [Employee::class],version = 2)
abstract class EmployeeDatabase:RoomDatabase() {

    abstract val employeeDAO:EmployeeDAO

    companion object{
        @Volatile
        private var INSTANCE:EmployeeDatabase?=null

        fun getInstance(context: Context):EmployeeDatabase{
            synchronized(lock = this){
                var instance:EmployeeDatabase?= INSTANCE
                    if(instance==null){
                        instance= Room.databaseBuilder(
                            context.applicationContext,
                            EmployeeDatabase::class.java,
                            "employee_data_table"
                        ).build()
                    }
                return instance
            }
        }
    }
}
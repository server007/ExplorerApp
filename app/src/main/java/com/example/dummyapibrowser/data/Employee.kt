package com.example.dummyapibrowser.data

import android.media.Image
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee_data_table")
data class Employee (

    @PrimaryKey
    val id: String,
    val title: String,
    val firstName: String,
    val lastName: String,
//    val gender: String,
    val email: String,
//    val dob: String,
//    val regDate: String,
//    val phone: String,
    val picture: String

)
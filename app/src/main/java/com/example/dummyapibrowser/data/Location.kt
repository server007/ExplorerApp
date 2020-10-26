package com.example.dummyapibrowser.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location_data_table")
data class Location (

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val street: String,
    val city: String,
    val state: String,
    val country: String,
    val timeZone: String
)

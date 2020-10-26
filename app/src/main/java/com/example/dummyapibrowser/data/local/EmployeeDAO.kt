package com.example.dummyapibrowser.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.dummyapibrowser.data.Employee

@Dao
interface EmployeeDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(employee:Employee):Long

    @Update
    suspend fun update(employee: Employee)

    @Delete
    suspend fun delete(employee: Employee)

    @Query("DELETE FROM employee_data_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM employee_data_table")
    fun getAllEmployees():LiveData<List<Employee>>
}
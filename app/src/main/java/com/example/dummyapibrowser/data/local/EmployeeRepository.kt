package com.example.dummyapibrowser.data.local

import com.example.dummyapibrowser.data.Employee

class EmployeeRepository(private val dao: EmployeeDAO) {

    val employees=dao.getAllEmployees()

    suspend fun insert(employee:Employee){
        dao.insert(employee)
    }

    suspend fun updateEmployee(employee: Employee){
        dao.update(employee)
    }

    suspend fun delete(employee: Employee){
        dao.delete(employee)
    }

    suspend fun deleteAll(){
        dao.deleteAll()
    }
}
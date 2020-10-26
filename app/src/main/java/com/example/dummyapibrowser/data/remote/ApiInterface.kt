package com.example.dummyapibrowser.data.remote

import androidx.lifecycle.MutableLiveData
import com.example.dummyapibrowser.data.AppVariables
import com.example.dummyapibrowser.data.Employee
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {

    //        MutableLiveData<String>(AppVariables.ApiKey)
    @Headers("app-id:${AppVariables.ApiKey}")
//    5f8e8d2d7dace61be7ce5952
    @GET("user")
    fun getEmployeeList():Call<ArrayList<Employee>>
//    @Headers(
//        "Cache-Control: max-age=60",
//        "Accept-Path": true"
//    )
//    @GET("v1/users/getDetail")
//    fun getUserDetails(): Single<UserInfo>
}
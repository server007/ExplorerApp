package com.example.dummyapibrowser.data.remote

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class ApiClient {

    private var BASE_URL:String="https://dummyapi.io/data/api/"
    private var retrofit:Retrofit?=null

    fun getApiClient():Retrofit?{
        if(retrofit==null){
            retrofit=Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit
    }
}
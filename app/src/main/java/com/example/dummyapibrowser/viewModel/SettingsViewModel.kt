package com.example.dummyapibrowser.viewModel

import android.view.View
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dummyapibrowser.data.AppVariables
import com.example.dummyapibrowser.data.local.EmployeeRepository

class SettingsViewModel(private val repository: EmployeeRepository):ViewModel(),Observable {


    var api_key=MutableLiveData<String>(AppVariables.ApiKey)

    var color=MutableLiveData<String>(AppVariables.color)


    fun editApiKey() {
        this.api_key=MutableLiveData()
    }

    fun colorChange(){
        this.color=MutableLiveData()
    }


        override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}
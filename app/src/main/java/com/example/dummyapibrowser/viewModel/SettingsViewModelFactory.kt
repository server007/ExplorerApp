package com.example.dummyapibrowser.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dummyapibrowser.data.local.EmployeeRepository

class SettingsViewModelFactory(private val repository: EmployeeRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SettingsViewModel::class.java)){
            return SettingsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}
package com.example.dummyapibrowser.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dummyapibrowser.data.local.EmployeeRepository
import java.lang.IllegalArgumentException

class SearchViewModelFactory(private val repository: EmployeeRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SearchViewModel::class.java)){
            return SearchViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}
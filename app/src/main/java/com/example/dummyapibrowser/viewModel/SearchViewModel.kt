package com.example.dummyapibrowser.viewModel

import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dummyapibrowser.data.Employee
import com.example.dummyapibrowser.data.local.EmployeeRepository
import com.example.dummyapibrowser.data.remote.ApiClient
import com.example.dummyapibrowser.data.remote.ApiInterface
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel(private val repository: EmployeeRepository):ViewModel(),Observable {

    val returnValue= MutableLiveData<Boolean>()
    val employees=repository.employees

    lateinit var searchedEmployee:MutableLiveData<String>

    lateinit var employee:MutableLiveData<Employee>

    var title= employee.value?.title
    var firstName= employee.value?.firstName
    var lastName= employee.value?.lastName
    var email= employee.value?.email

    fun getAllData(){
        var apiInterface: ApiInterface = ApiClient().getApiClient()!!
            .create(ApiInterface::class.java)

        apiInterface.getEmployeeList().enqueue(object : Callback<ArrayList<Employee>> {
            override fun onResponse(
                call: Call<ArrayList<Employee>>,
                response: Response<ArrayList<Employee>>?
            ) {
                if (response!!.isSuccessful){
                    returnValue.postValue(true)
                    response?.body()?.forEach {

                        insert(
                            Employee(it.id,it.title,it.firstName,it.lastName,it.email,
                            it.picture)
                        )
                    }
                }

            }

            override fun onFailure(call: Call<ArrayList<Employee>>, t: Throwable) {
                returnValue.postValue(false)
            }

        })
    }
    fun insert(employee: Employee){
        viewModelScope.launch {
            repository.insert(employee)
        }
    }


    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}
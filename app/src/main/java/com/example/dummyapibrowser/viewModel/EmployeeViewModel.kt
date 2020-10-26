package com.example.dummyapibrowser.viewModel

import android.content.Intent
import android.view.View
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dummyapibrowser.SearchActivity
import com.example.dummyapibrowser.data.Employee
import com.example.dummyapibrowser.data.local.EmployeeRepository
import com.example.dummyapibrowser.data.remote.ApiClient
import com.example.dummyapibrowser.data.remote.ApiInterface
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class EmployeeViewModel(private val repository: EmployeeRepository):ViewModel(),Observable {

    val returnValue=MutableLiveData<Boolean>()
    val employees=repository.employees

//    fun getAllData(){
//        var apiInterface:ApiInterface=ApiClient().getApiClient()!!
//            .create(ApiInterface::class.java)
//
//        apiInterface.getEmployeeList().enqueue(object :Callback<ArrayList<Employee>>{
//            override fun onResponse(
//                call: Call<ArrayList<Employee>>,
//                response: Response<ArrayList<Employee>>?
//            ) {
//                if (response!!.isSuccessful){
//                    returnValue.postValue(true)
//                    response?.body()?.forEach {
//                        insert(Employee(it.id,it.title,it.firstName,it.lastName,it.email,
//                            it.picture))
//                    }
//                }
//
//            }
//
//            override fun onFailure(call: Call<ArrayList<Employee>>, t: Throwable) {
//                returnValue.postValue(false)
//            }
//
//        })
//    }

    fun insert(employee: Employee){
        viewModelScope.launch {
            repository.insert(employee)
        }
    }

    fun goToMyEmployees(view:View){

    }

//    fun goToSearch(view: View){
//        val intent=Intent(this,SearchActivity::class.java).apply{
//
//        }
//        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
//            putExtra(EXTRA_MESSAGE, message)
//        }
//        startActivity(intent)
//    }

    fun goToSettings(view: View){

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }


}
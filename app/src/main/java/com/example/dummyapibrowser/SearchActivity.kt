package com.example.dummyapibrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dummyapibrowser.data.Employee
import com.example.dummyapibrowser.data.local.EmployeeDAO
import com.example.dummyapibrowser.data.local.EmployeeDatabase
import com.example.dummyapibrowser.data.local.EmployeeRepository
import com.example.dummyapibrowser.databinding.ActivityMainBinding
import com.example.dummyapibrowser.databinding.ActivitySearchBinding
import com.example.dummyapibrowser.view.BlankFragment
import com.example.dummyapibrowser.view.CompanyFragment
import com.example.dummyapibrowser.view.ErrorFragment
import com.example.dummyapibrowser.view.LoadingFragment
import com.example.dummyapibrowser.view.viewAdapter.MyRecyclerViewAdapter
import com.example.dummyapibrowser.viewModel.EmployeeViewModel
import com.example.dummyapibrowser.viewModel.EmployeeViewModelFactory
import com.example.dummyapibrowser.viewModel.SearchViewModel
import com.example.dummyapibrowser.viewModel.SearchViewModelFactory
import kotlinx.coroutines.launch

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_search)
//        setContentView(R.layout.activity_search)

        val dao:EmployeeDAO=EmployeeDatabase.getInstance(application).employeeDAO
        val repository=EmployeeRepository(dao)
        val factory=SearchViewModelFactory(repository)

        searchViewModel=ViewModelProvider(this,factory).get(SearchViewModel::class.java)
        binding.searchViewModel=searchViewModel
        binding.lifecycleOwner=this
        initRecyclerView()
    }

    private fun initRecyclerView(){
        openFragment(LoadingFragment())
        binding.employeeRecyclerView.layoutManager=LinearLayoutManager(this)
        searchViewModel.viewModelScope.launch { searchViewModel.getAllData()
        }
        searchViewModel.returnValue.observe(this,
            {
                if(it==true){
                    openFragment(BlankFragment())
                    displayList()
                }
                else{
                    openFragment(ErrorFragment())
                }
            })
    }

    private fun displayList(){
        searchViewModel.employees.observe(this,{it
            binding.employeeRecyclerView.adapter=MyRecyclerViewAdapter(it){
                selectedItem:Employee -> listItemClicked(selectedItem)
            }
        })
    }

    private fun listItemClicked(employee:Employee){
        openFragment(CompanyFragment())
        searchViewModel.employee= MutableLiveData(employee)
    }

    private fun openFragment(fragmentName: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_holder,fragmentName)
            .commit()
    }
}
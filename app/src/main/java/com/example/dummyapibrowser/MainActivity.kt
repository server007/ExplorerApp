package com.example.dummyapibrowser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.dummyapibrowser.databinding.ActivityMainBinding
//import com.example.dummyapibrowser.databinding.ActivityMainBinding
import com.example.dummyapibrowser.viewModel.EmployeeViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var employeeViewModel: EmployeeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun goToSearch(view: View) {
        val intent = Intent(this, SearchActivity::class.java).apply {
        }
            startActivity(intent)
    }

}
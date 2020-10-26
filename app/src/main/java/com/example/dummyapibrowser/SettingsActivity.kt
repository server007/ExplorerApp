package com.example.dummyapibrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dummyapibrowser.data.local.EmployeeDAO
import com.example.dummyapibrowser.data.local.EmployeeDatabase
import com.example.dummyapibrowser.data.local.EmployeeRepository
import com.example.dummyapibrowser.databinding.ActivitySettingsBinding
import com.example.dummyapibrowser.view.BlankFragment
import com.example.dummyapibrowser.view.ColorThemeFragment
import com.example.dummyapibrowser.view.EditApiFragment
import com.example.dummyapibrowser.viewModel.SettingsViewModel
import com.example.dummyapibrowser.viewModel.SettingsViewModelFactory

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding
    private lateinit var settingsViewModel: SettingsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_settings)
//        setContentView(R.layout.activity_settings)

        val dao:EmployeeDAO=EmployeeDatabase.getInstance(application).employeeDAO
        val repository=EmployeeRepository(dao)
        val factory = SettingsViewModelFactory(repository)

        settingsViewModel=ViewModelProvider(this,factory).get(SettingsViewModel::class.java)
        binding.settingsViewModel=settingsViewModel
        binding.lifecycleOwner=this
        openFragment(BlankFragment())
    }

    fun colorChange(view:View){
        settingsViewModel.colorChange()
        openFragment(ColorThemeFragment())
    }

    fun editApiKey() {
        settingsViewModel.editApiKey()
        openFragment(EditApiFragment())
    }

    private fun openFragment(fragmentName: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_holder2,fragmentName)
            .commit()
    }
}
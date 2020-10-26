package com.example.dummyapibrowser.view.viewAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dummyapibrowser.R
import com.example.dummyapibrowser.data.Employee
import com.example.dummyapibrowser.databinding.ListItemBinding

class MyRecyclerViewAdapter(private val employeeList: List<Employee>,
                            private val clickListener:(Employee) ->Unit):RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater:LayoutInflater= LayoutInflater.from(parent.context)
        val binding:ListItemBinding=
            DataBindingUtil.inflate(layoutInflater,R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(employeeList[position],clickListener)
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }
}


class MyViewHolder(val binding:ListItemBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(employee: Employee, clickListener: (Employee)->Unit){
        binding.headTextView.text=employee.firstName
        binding.listItemLayout.setOnClickListener{
            clickListener(employee)
        }
    }
}
package com.example.campdata.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.campdata.CampdataAdapter
import com.example.campdata.R
import com.example.campdata.data.Departments
import com.example.campdata.data.Programs


class DepartmentAdapter ( var Departments:List<Departments>) : RecyclerView.Adapter<DepartmentAdapter.Deptdataholder>() {


    //viewholder class
    inner class Deptdataholder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val tvdeptname = itemview.findViewById<TextView>(R.id.tv_programname)
        var tvcode = itemview.findViewById<TextView>(R.id.tv_code)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Deptdataholder {
        //layout to inflate to the recycler view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.program_item, parent, false)
        return Deptdataholder(view)
    }

    override fun onBindViewHolder(holder: Deptdataholder, position: Int) {
        //set values or listeners for the views
        var currentdepartment = Departments[position]

        holder.tvdeptname.text = currentdepartment.Name
        holder.tvcode.text = currentdepartment.Code


    }

    override fun getItemCount(): Int {
        return Departments.size
    }
}
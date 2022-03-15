package com.example.campdata.ui

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.campdata.CampdataAdapter
import com.example.campdata.R
import com.example.campdata.adapters.DepartmentAdapter
import com.example.campdata.viewModel.MyViewModelFactory
import com.example.campdata.viewModel.campDataViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DepartmentFragment : Fragment() {
    lateinit var tv_data: TextView
    lateinit var pg_recyclerview: RecyclerView

    @Inject
    lateinit var viewModelFactory: MyViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pg_recyclerview=view.findViewById(R.id.pg_recyclerview)

        // this creates a vertical layout Manager
        pg_recyclerview.layoutManager = LinearLayoutManager(requireContext())

        //creates an adapter
        val adapter= DepartmentAdapter(listOf())
        pg_recyclerview.adapter=adapter



        val viewModel= ViewModelProviders.of(this,viewModelFactory).get(campDataViewModel::class.java)


        viewModel.departmentList.observe(this, Observer {
            Log.d(ContentValues.TAG, "onCreate: $it")
            adapter.Departments=it   //it => all items in the list
            adapter.notifyDataSetChanged()
        })
        viewModel.errorMessage.observe(this, Observer {
        })
        viewModel.getDepartmentData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_department, container, false)
    }


}
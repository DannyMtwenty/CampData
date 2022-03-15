package com.example.campdata.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.campdata.CampdataAdapter
import com.example.campdata.R
import com.example.campdata.api.CampInterface
import com.example.campdata.data.Programs
import com.example.campdata.data.repository.CampDataRepository
import com.example.campdata.viewModel.MyViewModelFactory
import com.example.campdata.viewModel.campDataViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@AndroidEntryPoint
class ProgramFragment   : Fragment() {

    lateinit var tv_data: TextView
    lateinit var pg_recyclerview: RecyclerView

    lateinit var myViewModelFactory : MyViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_program, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pg_recyclerview=view.findViewById(R.id.pg_recyclerview)

        // this creates a vertical layout Manager
        pg_recyclerview.layoutManager = LinearLayoutManager(requireContext())

        //creates an adapter
        val adapter= CampdataAdapter(listOf())
        pg_recyclerview.adapter=adapter

        val viewModel=ViewModelProviders.of(this,myViewModelFactory).get(campDataViewModel::class.java)


        viewModel.programList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.Programs=it   //it => all items in the list
            adapter.notifyDataSetChanged()
        })
        viewModel.errorMessage.observe(this, Observer {
        })
        viewModel.getProgramData()


    }



}
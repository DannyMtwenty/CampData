package com.example.campdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.campdata.api.CampInterface
import com.example.campdata.data.Programs
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
     val base_url="http://41.89.227.23:8000/api/student/list/"
     lateinit var tv_data: TextView
     lateinit var pg_recyclerview: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        pg_recyclerview=findViewById(R.id.pg_recyclerview)

        // this creates a vertical layout Manager
        pg_recyclerview.layoutManager = LinearLayoutManager(this)




        getProgramData()
    }

    private fun getProgramData() {
        //creates an adapter
        val adapter= CampdataAdapter(listOf())
        pg_recyclerview.adapter=adapter

        //retrofit builder object
        val retrofitBuilder= Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create()) // we need to add converter factory to  convert JSON object to Java object
            .baseUrl(base_url)
            .build()
            .create(CampInterface::class.java)

        //get data from retrofitbuilder obj

        val retrofitdata=retrofitBuilder.getPrograms()

        retrofitdata.enqueue(object : Callback<List<Programs>?> {
            override fun onResponse(
                call: Call<List<Programs>?>,
                response: Response<List<Programs>?>
            ) {
                val responsebody=response.body()!!
//                val stringBuilder= StringBuilder()
//                for (data in responsebody){
//                    stringBuilder.append(data.Name)
//                    stringBuilder.append("\n")
//                }
                adapter.Programs=responsebody     //it => all items in the list
                adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Programs>?>, t: Throwable) {
                Log.d("MainActivity","onFailure"+t.message)
            }
        })

    }
}
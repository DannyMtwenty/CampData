package com.example.campdata.api

import com.example.campdata.data.Programs
import retrofit2.Call
import retrofit2.http.GET

interface CampInterface {

    @GET("programs")   //includes endpoint
    fun getPrograms() : Call<List<Programs>>
}
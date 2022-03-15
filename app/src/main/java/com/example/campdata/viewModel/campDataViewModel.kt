package com.example.campdata.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.campdata.CampdataAdapter
import com.example.campdata.api.CampInterface
import com.example.campdata.data.Programs
import com.example.campdata.data.repository.CampDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@HiltViewModel
class campDataViewModel @Inject constructor(private val campDataRepository: CampDataRepository) : ViewModel() {

    val programList = MutableLiveData<List<Programs>>()
    val errorMessage = MutableLiveData<String>()

     fun getProgramData() {


        val response=campDataRepository.getAllPrograms()

        response.enqueue(object : Callback<List<Programs>?> {
            override fun onResponse(
                call: Call<List<Programs>?>,
                response: Response<List<Programs>?>
            ) {
                programList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Programs>?>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }


}
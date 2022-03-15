package com.example.campdata.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.campdata.data.Departments
import com.example.campdata.data.Programs
import com.example.campdata.data.repository.CampDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class campDataViewModel @Inject constructor(private val campDataRepository: CampDataRepository) : ViewModel() {

    val programList = MutableLiveData<List<Programs>>()
    val departmentList = MutableLiveData<List<Departments>>()

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


    fun getDepartmentData() {


        val response=campDataRepository.getAllDepartments()

        response.enqueue(object : Callback<List<Departments>?> {
            override fun onResponse(
                call: Call<List<Departments>?>,
                response: Response<List<Departments>?>
            ) {
                departmentList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Departments>?>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }


}
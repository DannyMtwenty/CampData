package com.example.campdata.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.campdata.data.Departments
import com.example.campdata.data.Programs
import com.example.campdata.utils.Result
import com.example.campdata.data.repository.CampDataRepository
import com.example.campdata.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class campDataViewModel @Inject constructor(private val campDataRepository: CampDataRepository) : ViewModel() {


    val loading = MutableLiveData<Boolean>()
    val programList = MutableLiveData<List<Programs>>()
    val departmentList = MutableLiveData<Result<List<Departments>>>()



    val errorMessage = MutableLiveData<String>()

     fun getProgramData() {
         loading.postValue(true)



        val response=campDataRepository.getAllPrograms()

        response.enqueue(object : Callback<List<Programs>?> {
            override fun onResponse(
                call: Call<List<Programs>?>,
                response: Response<List<Programs>?>
            ) {
                programList.postValue(response.body())
                loading.postValue(false)
            }

            override fun onFailure(call: Call<List<Programs>?>, t: Throwable) {
                errorMessage.postValue(t.message)
                loading.postValue(false)
            }
        })
    }


    fun getDepartmentData() {
        departmentList.postValue(Result(Status.LOADING, null, "fetching departments"))



        val response=campDataRepository.getAllDepartments()

        response.enqueue(object : Callback<List<Departments>?> {
            override fun onResponse(
                call: Call<List<Departments>?>,
                response: Response<List<Departments>?>
            ) {

                departmentList.postValue(Result(Status.SUCCESS,response.body(),null))
            }

            override fun onFailure(call: Call<List<Departments>?>, t: Throwable) {
                errorMessage.postValue(t.message)
                departmentList.postValue(Result(Status.ERROR,null,t.message))
            }
        })
    }


}
package com.example.campdata.hilt

import com.example.campdata.api.CampInterface
import com.example.campdata.data.repository.CampDataRepository
import com.example.campdata.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)  //creates obj once when the app is started
@Module
object HiltModules {
    //things to inject
    @Singleton
    @Provides
    fun getApiInterface(): CampInterface {
        return return Retrofit.Builder()
            .baseUrl(Constants.base_url)
            .addConverterFactory(GsonConverterFactory.create()) // we need to add converter factory to  convert JSON object to Java object
            .build()
            .create(CampInterface::class.java)
    }

    @Provides
    fun provideRepository(campInterface: CampInterface) : CampDataRepository{
        return  CampDataRepository(campInterface)

    }
}
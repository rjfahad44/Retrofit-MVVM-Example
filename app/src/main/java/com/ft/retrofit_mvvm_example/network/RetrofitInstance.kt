package com.ft.retrofit_mvvm_example.network

import com.ft.retrofit_mvvm_example.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api : MoviesApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviesApiInterface::class.java)
    }
}
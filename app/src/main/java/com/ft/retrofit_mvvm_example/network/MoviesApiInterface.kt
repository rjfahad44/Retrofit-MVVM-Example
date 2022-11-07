package com.ft.retrofit_mvvm_example.network

import com.ft.retrofit_mvvm_example.data.model.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiInterface {
    @GET("popular?")
    fun getPopularMovies(@Query("api_key") api_key : String) : Call<Movies>
}
package com.ft.retrofit_mvvm_example.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ft.retrofit_mvvm_example.data.model.Movies
import com.ft.retrofit_mvvm_example.data.model.Results
import com.ft.retrofit_mvvm_example.network.RetrofitInstance
import com.ft.retrofit_mvvm_example.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {

    var movieLiveData = MutableLiveData<ArrayList<Results>>()

    fun getPopularMovies() {
        RetrofitInstance.api.getPopularMovies(Constants.API_KEY).enqueue(object :
            Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if (response.body()!=null){
                    movieLiveData.value = response.body()?.results
                }
                else{
                    Log.d("TAG","an errors occurrence")
                }
            }
            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }
        })
    }
}

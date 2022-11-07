package com.ft.retrofit_mvvm_example.data.model


import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: ArrayList<Results>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
package com.albersa.fetchcodingexercise.data.network.services

import com.albersa.fetchcodingexercise.data.network.RetrofitClient

object FetchApiClient {
    val apiService: FetchApiService by lazy {
        RetrofitClient.retrofit.create(FetchApiService::class.java)
    }
}
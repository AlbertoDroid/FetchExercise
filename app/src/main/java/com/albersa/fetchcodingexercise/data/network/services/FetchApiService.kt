package com.albersa.fetchcodingexercise.data.network.services

import com.albersa.fetchcodingexercise.data.models.Item
import retrofit2.http.GET

interface FetchApiService {
    @GET("hiring.json")
    suspend fun getList() : List<Item>
}
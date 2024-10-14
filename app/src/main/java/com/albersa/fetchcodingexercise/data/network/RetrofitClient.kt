package com.albersa.fetchcodingexercise.data.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"

    private val gson = GsonBuilder()
        .registerTypeAdapter(List::class.java, ItemDeserializer())
        .create()

    val retrofit: Retrofit by lazy {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.interceptors().add(logging)
        val client = clientBuilder.build()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }
}
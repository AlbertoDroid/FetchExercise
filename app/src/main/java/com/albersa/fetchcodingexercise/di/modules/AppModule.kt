package com.albersa.fetchcodingexercise.di.modules

import com.albersa.fetchcodingexercise.data.feature.items.ItemsRemoteDataSource
import com.albersa.fetchcodingexercise.data.network.ItemDeserializer
import com.albersa.fetchcodingexercise.data.network.services.FetchApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .registerTypeAdapter(List::class.java, ItemDeserializer())
            .create()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(gson: Gson): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.interceptors().add(logging)
        val client = clientBuilder.build()
        return Retrofit.Builder()
            .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): FetchApiService {
        return retrofit.create(FetchApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideItemsRemoteDataSource(fetchApiService: FetchApiService): ItemsRemoteDataSource {
        return ItemsRemoteDataSource(fetchApiService)
    }
}
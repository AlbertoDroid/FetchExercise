package com.albersa.fetchcodingexercise.data.feature.items

import com.albersa.fetchcodingexercise.data.models.Item
import com.albersa.fetchcodingexercise.data.network.services.FetchApiClient

class ItemsRemoteDataSource {
    private val fetchApiService = FetchApiClient.apiService

    suspend fun getItems(): List<Item> {
        return fetchApiService.getList()
    }
}
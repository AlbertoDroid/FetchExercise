package com.albersa.fetchcodingexercise.data.feature.items

import com.albersa.fetchcodingexercise.data.models.Item
import com.albersa.fetchcodingexercise.data.network.services.FetchApiService
import javax.inject.Inject

class ItemsRemoteDataSource @Inject constructor(private val fetchApiService: FetchApiService) {
    suspend fun getItems(): List<Item> {
        return fetchApiService.getList()
    }
}
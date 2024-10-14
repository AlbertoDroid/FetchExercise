package com.albersa.fetchcodingexercise.data.feature.items

import com.albersa.fetchcodingexercise.data.models.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ItemsRepository @Inject constructor(private val itemsRemoteDataSource: ItemsRemoteDataSource) {

    suspend fun getItems(): List<Item> {
        return withContext(Dispatchers.IO) {
            itemsRemoteDataSource.getItems()
        }
    }
}
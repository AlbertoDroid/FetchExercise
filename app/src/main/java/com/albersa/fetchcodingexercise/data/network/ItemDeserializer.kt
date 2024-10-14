package com.albersa.fetchcodingexercise.data.network

import com.albersa.fetchcodingexercise.data.models.Item
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class ItemDeserializer: JsonDeserializer<List<Item>> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): List<Item> {
        val jsonArray = json.asJsonArray
        return jsonArray.mapNotNull { jsonElement ->
            val item = context.deserialize<Item>(jsonElement, Item::class.java)
            if (item.name.isNullOrEmpty()) {
                null
            } else {
                item
            }
        }
    }
}
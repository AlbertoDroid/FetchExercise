package com.albersa.fetchcodingexercise.ui.mappings

import com.albersa.fetchcodingexercise.data.models.Item

data class Section<T>(
    val header: Long,
    val items: List<T>
)

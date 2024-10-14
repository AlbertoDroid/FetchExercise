package com.albersa.fetchcodingexercise.ui.mappings

data class Section<T>(
    val header: Long,
    val items: List<T>
)

package com.albersa.fetchcodingexercise.ui.common

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.albersa.fetchcodingexercise.ui.mappings.Section

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun <T> ListWithHeaders(
    sections: List<Section<T>>,
    headerContent: @Composable (String) -> Unit,
    itemContent: @Composable (T) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        sections.forEach { section ->
            stickyHeader {
                headerContent(section.header.toString())
            }

            items(section.items) { item ->
                itemContent(item)
            }
        }
    }

}
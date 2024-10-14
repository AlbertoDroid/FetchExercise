package com.albersa.fetchcodingexercise.ui.items

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.albersa.fetchcodingexercise.data.models.Item
import com.albersa.fetchcodingexercise.ui.common.ListWithHeaders
import com.albersa.fetchcodingexercise.ui.mappings.Section

@Composable
fun ItemsScreen(isLoading: Boolean, sections: List<Section<Item>>, modifier: Modifier = Modifier) {
    if (isLoading) {
        Box(
            modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    } else {
        ListWithHeaders(sections = sections, headerContent = { header ->
            ItemsHeader(header, modifier)
        }, itemContent = { item ->
            ItemContent(item, modifier)
        }, modifier)
    }
}
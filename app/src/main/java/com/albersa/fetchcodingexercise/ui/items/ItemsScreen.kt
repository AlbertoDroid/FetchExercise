package com.albersa.fetchcodingexercise.ui.items

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.albersa.fetchcodingexercise.data.models.Item
import com.albersa.fetchcodingexercise.ui.common.ListWithHeaders
import com.albersa.fetchcodingexercise.ui.mappings.Section

@Composable
fun ItemsScreen(sections: List<Section<Item>>, modifier: Modifier = Modifier) {
    ListWithHeaders(sections = sections, headerContent = { header ->
        ItemsHeader(header, modifier)
    }, itemContent =  { item ->
        ItemContent(item, modifier)
    }, modifier)
}
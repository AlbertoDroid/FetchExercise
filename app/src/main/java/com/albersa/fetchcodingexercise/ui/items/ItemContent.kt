package com.albersa.fetchcodingexercise.ui.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.albersa.fetchcodingexercise.R
import com.albersa.fetchcodingexercise.data.models.Item

@Composable
fun ItemContent(item: Item, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row {
                Text(text = stringResource(R.string.id_label))
                Text(text = item.id.toString())
            }
            Row(
                modifier = Modifier.paddingFromBaseline(top = 25.dp)
            ) {
                Text(text = stringResource(R.string.name_label))
                Text(text = item.name)
            }
        }
    }
}
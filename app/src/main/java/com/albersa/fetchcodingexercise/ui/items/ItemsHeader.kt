package com.albersa.fetchcodingexercise.ui.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.albersa.fetchcodingexercise.R

@Composable
fun ItemsHeader(title: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.surfaceContainer)
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
        ){
            Text(
                text = stringResource(R.string.section_label),
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}
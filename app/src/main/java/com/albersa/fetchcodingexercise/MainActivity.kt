package com.albersa.fetchcodingexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.albersa.fetchcodingexercise.data.models.Item
import com.albersa.fetchcodingexercise.ui.items.ItemsScreen
import com.albersa.fetchcodingexercise.ui.items.ItemsViewModel
import com.albersa.fetchcodingexercise.ui.mappings.Section
import com.albersa.fetchcodingexercise.ui.theme.FetchCodingExerciseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FetchCodingExerciseTheme {
                val viewModel: ItemsViewModel by viewModels()
                val items: List<Section<Item>> by viewModel.items.collectAsState()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ItemsScreen(
                        viewModel.isLoading.value,
                        items,
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

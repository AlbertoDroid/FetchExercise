package com.albersa.fetchcodingexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.albersa.fetchcodingexercise.data.models.Item
import com.albersa.fetchcodingexercise.ui.items.ItemsScreen
import com.albersa.fetchcodingexercise.ui.items.ItemsViewModel
import com.albersa.fetchcodingexercise.ui.mappings.Section
import com.albersa.fetchcodingexercise.ui.theme.FetchCodingExerciseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FetchCodingExerciseTheme {
                val viewModel: ItemsViewModel by viewModels()
                val items: List<Section<Item>> by viewModel.items.collectAsState()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ItemsScreen(
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

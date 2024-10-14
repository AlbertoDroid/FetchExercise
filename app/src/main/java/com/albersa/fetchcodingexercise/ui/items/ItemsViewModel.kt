package com.albersa.fetchcodingexercise.ui.items

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albersa.fetchcodingexercise.data.feature.items.ItemsRepository
import com.albersa.fetchcodingexercise.data.models.Item
import com.albersa.fetchcodingexercise.ui.mappings.Section
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(private val repository: ItemsRepository): ViewModel() {
    private val _items = MutableStateFlow<List<Section<Item>>>(emptyList())
    private val _isLoading = mutableStateOf(false)

    val items: StateFlow<List<Section<Item>>>
        get() = _items

    val isLoading: MutableState<Boolean>
        get() = _isLoading

    init {
        _isLoading.value = true
        getItems()
    }

    private fun getItems() {
        viewModelScope.launch {
            _items.value = convertToSectionList(repository.getItems())
            _isLoading.value = false
        }
    }

    private fun convertToSectionList(items: List<Item>): List<Section<Item>> {
        val sectionsMap = mutableMapOf<Long, List<Item>>()
        val sections = mutableListOf<Section<Item>>()
        items.forEach { item ->
            val header = sectionsMap[item.listId]
            header?.let {
                val newList = header.toMutableList()
                newList.add(item)
                sectionsMap[item.listId] = newList
            } ?: run {
                sectionsMap[item.listId] = mutableListOf(item)
            }
        }
        sectionsMap.forEach { entry ->
            val sortedList = entry.value.sortedBy { it.name }
            sections.add(Section(entry.key, sortedList))
        }
        return sections.sortedBy { it.header }
    }

}
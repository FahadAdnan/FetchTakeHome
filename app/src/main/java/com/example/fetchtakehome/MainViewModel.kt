package com.example.fetchtakehome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchtakehome.model.HiringItem
import com.example.fetchtakehome.networking.Api
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val api: Api
) : ViewModel() {

    val hiringItemState = MutableStateFlow<Map<String, List<HiringItem>>>(emptyMap())

    private suspend fun getHiringItems(): Map<String, List<HiringItem>> {
        val transactions = api.getHiringItems()

        val validTransactions = transactions.filter { !it.name.isNullOrBlank() }
        // filtering logic
        val groupedTransactions = validTransactions
            .groupBy { it.listId }
            .toSortedMap()
            .mapValues { entry -> entry.value.sortedBy {
                it.name!!.split(" ")[1].toInt()
            }}

        return groupedTransactions
    }

    init {
        viewModelScope.launch {
            hiringItemState.emit(getHiringItems())
        }
    }
}

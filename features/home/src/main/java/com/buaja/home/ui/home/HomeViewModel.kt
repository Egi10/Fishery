package com.buaja.home.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.buaja.home.domain.use_case.get_list.GetListPriceUseCase
import com.buaja.home.domain.use_case.get_list_highest_price.GetListHighestPriceUseCase
import com.buaja.home.domain.use_case.get_list_highest_size.GetListHighestSizeUseCase
import com.buaja.home.domain.use_case.get_list_lowest_price.GetListLowestPriceUseCase
import com.buaja.home.domain.use_case.get_list_lowest_size.GetListLowestSizeUseCase
import com.buaja.home.ui.home.model.HomeUiState
import com.buaja.home.ui.sort.model.Filter
import com.buaja.sync.domain.use_case.SyncDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * @created 06/03/22 15.47
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getListPriceUseCase: GetListPriceUseCase,
    private val getListLowestPriceUseCase: GetListLowestPriceUseCase,
    private val getListHighestPriceUseCase: GetListHighestPriceUseCase,
    private val syncDataUseCase: SyncDataUseCase,
    private val getListHighestSizeUseCase: GetListHighestSizeUseCase,
    private val getListLowestSizeUseCase: GetListLowestSizeUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> get() = _uiState

    private val _listFilter = MutableStateFlow<List<Filter>>(listOf())
    val listFilter: StateFlow<List<Filter>> get() = _listFilter

    fun getListPrice() {
        viewModelScope.launch {
            syncDataUseCase.invoke()
                .onStart {
                    _uiState.update { uiState ->
                        uiState.copy(
                            loading = true
                        )
                    }
                }
                .onCompletion {
                    _uiState.update { uiState ->
                        uiState.copy(
                            loading = false
                        )
                    }
                }
                .catch {
                    getAllList()
                }
                .zip(getListPriceUseCase.invoke()) { _, local ->
                    return@zip local
                }
                .collect {
                    _uiState.update { uiState ->
                        uiState.copy(
                            list = it
                        )
                    }
                }
        }
    }

    fun getSelectedFilter() {
        viewModelScope.launch {
            val filter = listFilter.value.filter {
                it.status
            }
            when {
                filter[0].text.contains("harga terendah", ignoreCase = true) -> {
                    getListLowestPriceUseCase.invoke()
                        .collect {
                            _uiState.update { uiState ->
                                uiState.copy(
                                    list = it
                                )
                            }
                        }
                }
                filter[0].text.contains("harga tertinggi", ignoreCase = true) -> {
                    getListHighestPriceUseCase.invoke()
                        .collect {
                            _uiState.update { uiState ->
                                uiState.copy(
                                    list = it
                                )
                            }
                        }
                }
                filter[0].text.contains("ukuran terkecil", ignoreCase = true) -> {
                    getListLowestSizeUseCase.invoke()
                        .collect {
                            _uiState.update { uiState ->
                                uiState.copy(
                                    list = it
                                )
                            }
                        }
                }
                filter[0].text.contains("ukuran terbesar", ignoreCase = true) -> {
                    getListHighestSizeUseCase.invoke()
                        .collect {
                            _uiState.update { uiState ->
                                uiState.copy(
                                    list = it
                                )
                            }
                        }
                }
                else -> {
                    getAllList()
                }
            }
        }
    }

    private suspend fun getAllList() {
        getListPriceUseCase.invoke()
            .collect {
                _uiState.update { uiState ->
                    uiState.copy(
                        list = it
                    )
                }
            }
    }

    fun setFilter(list: List<Filter>) {
        _listFilter.value = list
    }

    fun updateFilter(positions: Int) {
        _listFilter.update {
            it.mapIndexed { index, filter ->
                filter.status = index == positions
            }
            it
        }
    }

    fun showSortDialog() {
        _uiState.update {
            it.copy(
                showSortDialog = true
            )
        }
    }

    fun hideSortDialog() {
        _uiState.update {
            it.copy(
                showSortDialog = false
            )
        }
    }
}
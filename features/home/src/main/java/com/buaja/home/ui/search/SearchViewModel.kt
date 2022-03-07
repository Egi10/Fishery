package com.buaja.home.ui.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.buaja.home.domain.use_case.get_list_commodity.GetListCommodityUseCase
import com.buaja.home.ui.search.model.SearchUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * @created 07/03/22 07.41
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getListCommodityUseCase: GetListCommodityUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> get() = _uiState

    fun setQuery(value: String) {
        _uiState.update {
            it.copy(
                keyword = value
            )
        }
    }

    fun getListByCommodity(commodity: String) {
        viewModelScope.launch {
            getListCommodityUseCase.invoke(commodity)
                .catch {
                    Log.d("Error", "Error ${it.message}")
                }
                .collect {
                    if (it.isEmpty()) {
                        _uiState.update { uiState ->
                            uiState.copy(
                                list = it,
                                emptyData = true
                            )
                        }
                    } else {
                        _uiState.update { uiState ->
                            uiState.copy(
                                list = it,
                                emptyData = false
                            )
                        }
                    }
                }
        }
    }

    fun clearSearch() {
        _uiState.update {
            it.copy(
                keyword = "",
                list = listOf()
            )
        }
    }
}
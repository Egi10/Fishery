package com.buaja.home.ui.filter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.buaja.home.domain.use_case.get_list_options_area.GetListOptionsAreaUseCase
import com.buaja.home.ui.filter.model.Filter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * @created 07/03/22 18.00
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@HiltViewModel
class FilterViewModel @Inject constructor(
    private val getListOptionsAreaUseCase: GetListOptionsAreaUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<List<Filter>>(listOf())
    val uiState: StateFlow<List<Filter>> get() = _uiState

    init {
        getAllListOptionsArea()
    }

    private fun getAllListOptionsArea() {
        viewModelScope.launch {
            getListOptionsAreaUseCase.invoke()
                .collect {
                    val list: MutableList<Filter> = mutableListOf()
                    it.map { area ->
                        list.add(
                            Filter(
                                area = area,
                                status = false
                            )
                        )
                    }
                    _uiState.value = list
                }
        }
    }

    fun updateFilter(positions: Int) {
        _uiState.update {
            it.mapIndexed { index, filter ->
                filter.status = index == positions
            }
            it
        }
    }

    fun clearFilter() {
        _uiState.update {
            it.mapIndexed { _, filter ->
                filter.status = false
            }
            it
        }
    }
}
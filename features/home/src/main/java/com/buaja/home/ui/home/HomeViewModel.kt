package com.buaja.home.ui.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.buaja.home.domain.use_case.get_list.GetListPriceUseCase
import com.buaja.home.ui.home.model.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * @created 06/03/22 15.47
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getListPriceUseCase: GetListPriceUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState get() = _uiState

    fun getListPrice() {
        viewModelScope.launch {
            getListPriceUseCase.invoke()
                .collect {
                    Log.d("Data", "${it.size}")
                    _uiState.update { uiState ->
                        uiState.copy(
                            list = it
                        )
                    }
                }
        }
    }
}
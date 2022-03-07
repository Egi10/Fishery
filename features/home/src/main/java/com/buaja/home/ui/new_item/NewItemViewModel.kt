package com.buaja.home.ui.new_item

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.buaja.abstraction.extensions.hashString
import com.buaja.home.domain.model.NewItemRequest
import com.buaja.home.domain.use_case.save_new_item.SaveNewItemUseCase
import com.buaja.home.ui.new_item.model.NewItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


/**
 * @created 07/03/22 19.13
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@HiltViewModel
class NewItemViewModel @Inject constructor(
    private val saveNewItemUseCase: SaveNewItemUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(NewItem())
    val uiState: StateFlow<NewItem> get() = _uiState

    fun clear() {
        _uiState.update {
            it.copy(
                success = false,
                loading = false,
                commodity = "",
                size = "",
                price = "",
                areaProvince = "",
                areaCity = ""
            )
        }
    }

    fun setAreaProvince(value: String) {
        _uiState.update {
            it.copy(
                areaProvince = value
            )
        }
    }

    fun setAreaCity(value: String) {
        _uiState.update {
            it.copy(
                areaCity = value
            )
        }
    }

    fun setCommodity(value: String) {
        _uiState.update {
            it.copy(
                commodity = value
            )
        }
    }

    fun setPrice(value: String) {
        _uiState.update {
            it.copy(
                price = value
            )
        }
    }

    fun setSize(value: String) {
        _uiState.update {
            it.copy(
                size = value
            )
        }
    }

    fun saveNewItem() {
        viewModelScope.launch {
            val timeStamp = (System.currentTimeMillis() / 1000).toString()

            val newItem = NewItemRequest(
                price = uiState.value.price,
                size = uiState.value.size,
                commodity = uiState.value.commodity,
                areaCity = uiState.value.areaCity,
                areaProvince = uiState.value.areaProvince,
                timestamp = timeStamp,
                uuid = timeStamp.hashString(),
                dateParse = getCurrentDateTime()
            )
            saveNewItemUseCase.invoke(newItem)
                .onStart {
                    _uiState.update {
                        it.copy(
                            loading = true
                        )
                    }
                }
                .onCompletion {
                    _uiState.update {
                        it.copy(
                            loading = false
                        )
                    }
                }
                .catch {
                    Log.d("Error", "Error ${it.message}")
                }
                .collect {
                    _uiState.update { uiState ->
                        uiState.copy(
                            success = true
                        )
                    }
                }
        }
    }

    private fun getCurrentDateTime(): String {
        val calendar = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault())
        return dateFormat.format(calendar)
    }
}
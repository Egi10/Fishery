package com.buaja.home.ui.home.model

import com.buaja.home.domain.model.ListPrice


/**
 * @created 06/03/22 15.55
 * @author Julsapargi Nursam
 * @project Fishery
 **/

data class HomeUiState(
    val list: List<ListPrice> = emptyList(),
    val loading: Boolean = false,
    val showSortDialog: Boolean = false,
    val showSearchDialog: Boolean = false
)
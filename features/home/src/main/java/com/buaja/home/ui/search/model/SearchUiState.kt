package com.buaja.home.ui.search.model

import com.buaja.home.domain.model.ListPrice


/**
 * @created 07/03/22 07.43
 * @author Julsapargi Nursam
 * @project Fishery
 **/

data class SearchUiState(
    val keyword: String = "",
    val list: List<ListPrice> = emptyList(),
    val emptyData: Boolean = false
)

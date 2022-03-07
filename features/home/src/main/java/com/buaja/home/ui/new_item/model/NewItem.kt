package com.buaja.home.ui.new_item.model


/**
 * @created 07/03/22 19.14
 * @author Julsapargi Nursam
 * @project Fishery
 **/

data class NewItem(
    val areaProvince: String = "",
    val areaCity: String = "",
    val commodity: String = "",
    val price: String = "",
    val size: String = "",
    val loading: Boolean = false,
    val success: Boolean = false
)

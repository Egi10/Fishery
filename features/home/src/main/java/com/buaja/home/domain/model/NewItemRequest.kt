package com.buaja.home.domain.model


/**
 * @created 07/03/22 19.30
 * @author Julsapargi Nursam
 * @project Fishery
 **/

data class NewItemRequest(
    val areaProvince: String,
    val areaCity: String,
    val commodity: String,
    val price: String,
    val size: String,
    val dateParse: String,
    val timestamp: String,
    val uuid: String
)
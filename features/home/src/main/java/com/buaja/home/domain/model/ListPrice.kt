package com.buaja.home.domain.model

import com.buaja.database.entity.ListEntity


/**
 * @created 06/03/22 15.31
 * @author Julsapargi Nursam
 * @project Fishery
 **/

data class ListPrice(
    val name: String,
    val price: String,
    val areaProvince: String,
    val areaCity: String,
    val size: String
)

fun List<ListEntity>.mapEntity(): List<ListPrice> {
    return this.map {
        ListPrice(
            name = it.commodity,
            price = it.price,
            areaProvince = it.areaProvince,
            areaCity = it.areaCity,
            size = it.size
        )
    }
}

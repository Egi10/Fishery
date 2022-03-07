package com.buaja.sync.utils

import com.buaja.abstraction.extensions.hashString
import com.buaja.database.entity.ListEntity
import com.buaja.database.entity.OptionsAreaEntity
import com.buaja.database.entity.OptionsSizeEntity
import com.buaja.sync.data.source.remote.response.ListResponseItem
import com.buaja.sync.data.source.remote.response.OptionsAreaResponseItem
import com.buaja.sync.data.source.remote.response.OptionsSizeResponseItem


/**
 * @created 06/03/22 10.56
 * @author Julsapargi Nursam
 * @project Fishery
 **/

object DataMapper {
    fun mapListResponseToListEntity(list: List<ListResponseItem>): List<ListEntity> {
        val newListEntity: MutableList<ListEntity> = mutableListOf()

        list.map {
            newListEntity.add(
                ListEntity(
                    areaCity = it.areaCity ?: "",
                    size = it.size ?: "",
                    areaProvince = it.areaProvince ?: "",
                    commodity = it.commodity ?: "",
                    price = it.price ?: "",
                    tglParsed = it.tglParsed ?: "",
                    timestamp = it.timestamp ?: "",
                    uuid = if (it.uuid.isNullOrEmpty()) {
                        it.tglParsed.toString().hashString()
                    } else {
                        it.uuid
                    }
                )
            )
        }

        return newListEntity
    }

    fun mapOptionsAreaResponseToOptionsAreaEntity(list: List<OptionsAreaResponseItem>): List<OptionsAreaEntity> {
        val newListEntity: MutableList<OptionsAreaEntity> = mutableListOf()

        list.map {
            newListEntity.add(
                OptionsAreaEntity(
                    city = it.city,
                    province = it.province
                )
            )
        }

        return newListEntity
    }

    fun mapOptionsSizeResponseToOptionsSizeEntity(list: List<OptionsSizeResponseItem>): List<OptionsSizeEntity> {
        val newListEntity: MutableList<OptionsSizeEntity> = mutableListOf()

        list.map {
            newListEntity.add(
                OptionsSizeEntity(
                    size = it.size
                )
            )
        }

        return newListEntity
    }
}
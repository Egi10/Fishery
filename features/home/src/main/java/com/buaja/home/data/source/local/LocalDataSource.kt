package com.buaja.home.data.source.local

import com.buaja.database.entity.ListEntity
import com.buaja.database.entity.OptionsAreaEntity
import kotlinx.coroutines.flow.Flow


/**
 * @created 06/03/22 15.15
 * @author Julsapargi Nursam
 * @project Fishery
 **/

interface LocalDataSource {
    fun getAllList(): Flow<List<ListEntity>>
    fun getAllListByLowestPrice(): Flow<List<ListEntity>>
    fun getAllListByHighestPrice(): Flow<List<ListEntity>>
    fun getAllListByLowestSize(): Flow<List<ListEntity>>
    fun getAllListByHighestSize(): Flow<List<ListEntity>>
    fun getListByCommodity(commodity: String): Flow<List<ListEntity>>
    fun getListOptionArea(): Flow<List<OptionsAreaEntity>>
    fun getListByOptionsAreaProvince(areaProvince: String): Flow<List<ListEntity>>
}
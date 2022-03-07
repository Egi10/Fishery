package com.buaja.home.domain.repository

import com.buaja.home.domain.model.ListPrice
import kotlinx.coroutines.flow.Flow


/**
 * @created 06/03/22 15.37
 * @author Julsapargi Nursam
 * @project Fishery
 **/

interface ListPriceRepository {
    fun getAllList(): Flow<List<ListPrice>>
    fun getAllListByLowestPrice(): Flow<List<ListPrice>>
    fun getAllListByHighestPrice(): Flow<List<ListPrice>>
    fun getAllListByLowestSize(): Flow<List<ListPrice>>
    fun getAllListByHighestSize(): Flow<List<ListPrice>>
}
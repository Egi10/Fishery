package com.buaja.home.data.source.local

import com.buaja.database.entity.ListEntity
import kotlinx.coroutines.flow.Flow


/**
 * @created 06/03/22 15.15
 * @author Julsapargi Nursam
 * @project Fishery
 **/

interface LocalDataSource {
    fun getAllList(): Flow<List<ListEntity>>
}
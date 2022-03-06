package com.buaja.sync.data.source.local

import com.buaja.database.entity.ListEntity
import com.buaja.database.entity.OptionsAreaEntity
import com.buaja.database.entity.OptionsSizeEntity


/**
 * @created 06/03/22 10.08
 * @author Julsapargi Nursam
 * @project Fishery
 **/

interface LocalDataSource {
    suspend fun insertList(list: List<ListEntity>)
    suspend fun insertOptionsArea(list: List<OptionsAreaEntity>)
    suspend fun insertOptionsSize(list: List<OptionsSizeEntity>)
}
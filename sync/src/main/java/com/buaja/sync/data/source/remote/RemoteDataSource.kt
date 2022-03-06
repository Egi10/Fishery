package com.buaja.sync.data.source.remote

import com.buaja.sync.data.source.remote.response.ListResponseItem
import com.buaja.sync.data.source.remote.response.OptionsAreaResponseItem
import com.buaja.sync.data.source.remote.response.OptionsSizeResponseItem


/**
 * @created 06/03/22 09.57
 * @author Julsapargi Nursam
 * @project Fishery
 **/

interface RemoteDataSource {
    suspend fun getList(): List<ListResponseItem>
    suspend fun getOptionsArea(): List<OptionsAreaResponseItem>
    suspend fun getOptionsSize(): List<OptionsSizeResponseItem>
}
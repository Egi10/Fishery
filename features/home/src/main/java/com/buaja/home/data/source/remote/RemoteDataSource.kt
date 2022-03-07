package com.buaja.home.data.source.remote

import com.buaja.home.data.source.remote.response.SaveResponse
import kotlinx.coroutines.flow.Flow


/**
 * @created 07/03/22 19.34
 * @author Julsapargi Nursam
 * @project Fishery
 **/

interface RemoteDataSource {
    fun saveNewItem(data: Any?): Flow<SaveResponse>
}
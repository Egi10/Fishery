package com.buaja.sync.data.source.remote

import com.buaja.abstraction.di.IoDispatcher
import com.buaja.sync.data.source.remote.response.ListResponseItem
import com.buaja.sync.data.source.remote.response.OptionsAreaResponseItem
import com.buaja.sync.data.source.remote.response.OptionsSizeResponseItem
import com.buaja.sync.data.source.remote.routes.FisheryService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject


/**
 * @created 06/03/22 09.59
 * @author Julsapargi Nursam
 * @project Fishery
 **/

class RemoteDataSourceImpl @Inject constructor(
    private val fisheryService: FisheryService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : RemoteDataSource {
    override suspend fun getList(): List<ListResponseItem> {
        return withContext(ioDispatcher) {
            fisheryService.getList()
        }
    }

    override suspend fun getOptionsArea(): List<OptionsAreaResponseItem> {
        return withContext(ioDispatcher) {
            fisheryService.getOptionsArea()
        }
    }

    override suspend fun getOptionsSize(): List<OptionsSizeResponseItem> {
        return withContext(ioDispatcher) {
            fisheryService.getOptionsSize()
        }
    }
}
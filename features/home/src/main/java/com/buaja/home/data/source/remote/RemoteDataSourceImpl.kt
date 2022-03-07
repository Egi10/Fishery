package com.buaja.home.data.source.remote

import com.buaja.abstraction.di.IoDispatcher
import com.buaja.home.data.source.remote.response.SaveResponse
import com.buaja.home.data.source.remote.routes.ItemService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


/**
 * @created 07/03/22 19.36
 * @author Julsapargi Nursam
 * @project Fishery
 **/

class RemoteDataSourceImpl @Inject constructor(
    private val itemService: ItemService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : RemoteDataSource {
    override fun saveNewItem(data: Any?): Flow<SaveResponse> {
        return flow {
            emit(
                itemService.saveNewItem(
                    post = data
                )
            )
        }.flowOn(ioDispatcher)
    }
}
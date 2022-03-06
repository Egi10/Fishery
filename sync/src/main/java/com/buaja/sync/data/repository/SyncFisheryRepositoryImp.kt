package com.buaja.sync.data.repository

import com.buaja.sync.data.source.local.LocalDataSource
import com.buaja.sync.data.source.remote.RemoteDataSource
import com.buaja.sync.domain.repository.SyncFisheryRepository
import com.buaja.sync.utils.DataMapper
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject


/**
 * @created 06/03/22 10.43
 * @author Julsapargi Nursam
 * @project Fishery
 **/

class SyncFisheryRepositoryImp @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : SyncFisheryRepository {
    override suspend fun syncData(): Unit = coroutineScope {
        val sync = listOf(
            async {
                val listRemote = remoteDataSource.getList()
                localDataSource.insertList(
                    DataMapper.mapListResponseToListEntity(listRemote)
                )
            },
            async {
                val listRemote = remoteDataSource.getOptionsArea()
                localDataSource.insertOptionsArea(
                    DataMapper.mapOptionsAreaResponseToOptionsAreaEntity(listRemote)
                )
            },
            async {
                val listRemote = remoteDataSource.getOptionsSize()
                localDataSource.insertOptionsSize(
                    DataMapper.mapOptionsSizeResponseToOptionsSizeEntity(listRemote)
                )
            }
        )

        sync.awaitAll()
    }
}
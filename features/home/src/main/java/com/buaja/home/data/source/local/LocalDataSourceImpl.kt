package com.buaja.home.data.source.local

import com.buaja.abstraction.di.IoDispatcher
import com.buaja.database.dao.ListDao
import com.buaja.database.entity.ListEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


/**
 * @created 06/03/22 15.15
 * @author Julsapargi Nursam
 * @project Fishery
 **/

class LocalDataSourceImpl @Inject constructor(
    private val listDao: ListDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : LocalDataSource {
    override fun getAllList(): Flow<List<ListEntity>> {
        return listDao.getAllList()
            .flowOn(ioDispatcher)
    }
}
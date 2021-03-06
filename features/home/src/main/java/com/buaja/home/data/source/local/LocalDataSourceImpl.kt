package com.buaja.home.data.source.local

import com.buaja.abstraction.di.IoDispatcher
import com.buaja.database.dao.ListDao
import com.buaja.database.dao.OptionsAreaDao
import com.buaja.database.entity.ListEntity
import com.buaja.database.entity.OptionsAreaEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


/**
 * @created 06/03/22 15.15
 * @author Julsapargi Nursam
 * @project Fishery
 **/

class LocalDataSourceImpl @Inject constructor(
    private val listDao: ListDao,
    private val optionsAreaDao: OptionsAreaDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : LocalDataSource {
    override fun getAllList(): Flow<List<ListEntity>> {
        return listDao.getAllList()
            .flowOn(ioDispatcher)
    }

    override fun getAllListByLowestPrice(): Flow<List<ListEntity>> {
        return listDao.getAllListByLowestPrice()
            .flowOn(ioDispatcher)
    }

    override fun getAllListByHighestPrice(): Flow<List<ListEntity>> {
        return listDao.getAllListByHighestPrice()
            .flowOn(ioDispatcher)
    }

    override fun getAllListByLowestSize(): Flow<List<ListEntity>> {
        return listDao.getAllListByLowestSize()
            .flowOn(ioDispatcher)
    }

    override fun getAllListByHighestSize(): Flow<List<ListEntity>> {
        return listDao.getAllListByHighestSize()
            .flowOn(ioDispatcher)
    }

    override fun getListByCommodity(commodity: String): Flow<List<ListEntity>> {
        return listDao.getListByCommodity(commodity)
            .flowOn(ioDispatcher)
    }

    override fun getListOptionArea(): Flow<List<OptionsAreaEntity>> {
        return optionsAreaDao.getAllOptionArea()
            .flowOn(ioDispatcher)
    }

    override fun getListByOptionsAreaProvince(areaProvince: String): Flow<List<ListEntity>> {
        return listDao.getListByAreaProvince(areaProvince)
            .flowOn(ioDispatcher)
    }

    override fun saveList(listEntity: ListEntity): Flow<Unit> {
        return flow<Unit> {
            listDao.insert(
                listEntity
            )
        }.flowOn(ioDispatcher)
    }
}
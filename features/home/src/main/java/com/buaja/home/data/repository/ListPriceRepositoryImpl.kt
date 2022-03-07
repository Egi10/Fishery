package com.buaja.home.data.repository

import com.buaja.home.data.source.local.LocalDataSource
import com.buaja.home.data.source.remote.RemoteDataSource
import com.buaja.home.domain.model.ListPrice
import com.buaja.home.domain.model.NewItemRequest
import com.buaja.home.domain.model.mapEntity
import com.buaja.home.domain.repository.ListPriceRepository
import com.buaja.sync.data.source.remote.response.ListResponseItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


/**
 * @created 06/03/22 15.38
 * @author Julsapargi Nursam
 * @project Fishery
 **/

class ListPriceRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : ListPriceRepository {
    override fun getAllList(): Flow<List<ListPrice>> {
        return localDataSource.getAllList().map {
            it.mapEntity()
        }
    }

    override fun getAllListByLowestPrice(): Flow<List<ListPrice>> {
        return localDataSource.getAllListByLowestPrice().map {
            it.mapEntity()
        }
    }

    override fun getAllListByHighestPrice(): Flow<List<ListPrice>> {
        return localDataSource.getAllListByHighestPrice().map {
            it.mapEntity()
        }
    }

    override fun getAllListByLowestSize(): Flow<List<ListPrice>> {
        return localDataSource.getAllListByLowestSize().map {
            it.mapEntity()
        }
    }

    override fun getAllListByHighestSize(): Flow<List<ListPrice>> {
        return localDataSource.getAllListByHighestSize().map {
            it.mapEntity()
        }
    }

    override fun getListByCommodity(commodity: String): Flow<List<ListPrice>> {
        return localDataSource.getListByCommodity(commodity).map {
            it.mapEntity()
        }
    }

    override fun getListByAreaProvince(areaProvince: String): Flow<List<ListPrice>> {
        return localDataSource.getListByOptionsAreaProvince(areaProvince).map {
            it.mapEntity()
        }
    }

    override fun saveNewItem(newItemRequest: NewItemRequest): Flow<String> {
        val listResponseItem = listOf(
            ListResponseItem(
                uuid = newItemRequest.uuid,
                timestamp = newItemRequest.timestamp,
                areaProvince = newItemRequest.areaProvince,
                areaCity = newItemRequest.areaCity,
                commodity = newItemRequest.areaCity,
                size = newItemRequest.size,
                price = newItemRequest.price,
                tglParsed = newItemRequest.dateParse
            )
        )
        return remoteDataSource.saveNewItem(listResponseItem).map {
            it.updatedRange
        }
    }
}
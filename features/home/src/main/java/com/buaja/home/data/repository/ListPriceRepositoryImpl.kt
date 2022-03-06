package com.buaja.home.data.repository

import com.buaja.home.data.source.local.LocalDataSource
import com.buaja.home.domain.model.ListPrice
import com.buaja.home.domain.model.mapEntity
import com.buaja.home.domain.repository.ListPriceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


/**
 * @created 06/03/22 15.38
 * @author Julsapargi Nursam
 * @project Fishery
 **/

class ListPriceRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
): ListPriceRepository {
    override fun getAllList(): Flow<List<ListPrice>> {
        return localDataSource.getAllList().map {
            it.mapEntity()
        }
    }
}
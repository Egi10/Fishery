package com.buaja.home.data.repository

import com.buaja.home.data.source.local.LocalDataSource
import com.buaja.home.domain.repository.OptionsAreaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


/**
 * @created 07/03/22 17.53
 * @author Julsapargi Nursam
 * @project Fishery
 **/

class OptionsAreaRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : OptionsAreaRepository {
    override fun getAllOptionsArea(): Flow<List<String>> {
        return localDataSource.getListOptionArea().map {
            it.map { optionsArea ->
                optionsArea.province
            }
        }
    }
}
package com.buaja.sync.data.source.local

import com.buaja.abstraction.di.IoDispatcher
import com.buaja.database.dao.ListDao
import com.buaja.database.dao.OptionsAreaDao
import com.buaja.database.dao.OptionsSizeDao
import com.buaja.database.entity.ListEntity
import com.buaja.database.entity.OptionsAreaEntity
import com.buaja.database.entity.OptionsSizeEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject


/**
 * @created 06/03/22 10.12
 * @author Julsapargi Nursam
 * @project Fishery
 **/

class LocalDataSourceImpl @Inject constructor(
    private val listDao: ListDao,
    private val optionsAreaDao: OptionsAreaDao,
    private val optionSizeDao: OptionsSizeDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : LocalDataSource {
    override suspend fun insertList(list: List<ListEntity>) = withContext(ioDispatcher) {
        listDao.insert(list)
    }

    override suspend fun insertOptionsArea(list: List<OptionsAreaEntity>) =
        withContext(ioDispatcher) {
            optionsAreaDao.insert(list)
        }

    override suspend fun insertOptionsSize(list: List<OptionsSizeEntity>) =
        withContext(ioDispatcher) {
            optionSizeDao.insert(list)
        }
}
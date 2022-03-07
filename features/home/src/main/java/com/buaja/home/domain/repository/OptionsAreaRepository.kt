package com.buaja.home.domain.repository

import com.buaja.database.entity.OptionsAreaEntity
import kotlinx.coroutines.flow.Flow


/**
 * @created 07/03/22 17.53
 * @author Julsapargi Nursam
 * @project Fishery
 **/

interface OptionsAreaRepository {
    fun getAllOptionsArea(): Flow<List<String>>
}
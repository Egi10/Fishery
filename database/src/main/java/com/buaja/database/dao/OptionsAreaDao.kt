package com.buaja.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.buaja.database.entity.OptionsAreaEntity
import kotlinx.coroutines.flow.Flow


/**
 * @created 05/03/22 16.30
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Dao
interface OptionsAreaDao : BaseDao<OptionsAreaEntity> {
    @Query(
        """
            SELECT * FROM options_area
        """
    )
    fun getAllOptionArea(): Flow<List<OptionsAreaEntity>>
}
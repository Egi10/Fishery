package com.buaja.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.buaja.database.entity.ListEntity
import kotlinx.coroutines.flow.Flow


/**
 * @created 05/03/22 16.25
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Dao
interface ListDao : BaseDao<ListEntity> {
    @Query("""
        SELECT * FROM list
    """)
    fun getAllList(): Flow<List<ListEntity>>
}
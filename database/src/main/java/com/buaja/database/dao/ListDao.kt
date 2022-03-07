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
    @Query(
        """
        SELECT * FROM list
    """
    )
    fun getAllList(): Flow<List<ListEntity>>

    @Query(
        """
            SELECT * FROM list ORDER BY price + 0 ASC
        """
    )
    fun getAllListByLowestPrice(): Flow<List<ListEntity>>

    @Query(
        """
            SELECT * FROM list ORDER BY price + 0 DESC
        """
    )
    fun getAllListByHighestPrice(): Flow<List<ListEntity>>

    @Query(
        """
            SELECT * FROM list ORDER BY size + 0 ASC
        """
    )
    fun getAllListByLowestSize(): Flow<List<ListEntity>>

    @Query(
        """
            SELECT * FROM list ORDER BY size + 0 DESC
        """
    )
    fun getAllListByHighestSize(): Flow<List<ListEntity>>
}
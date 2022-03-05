package com.buaja.database.dao

import androidx.room.*


/**
 * @created 05/03/22 16.18
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Dao
interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: List<T>)

    @Update
    suspend fun update(data: T)

    @Delete
    suspend fun delete(data: T)
}
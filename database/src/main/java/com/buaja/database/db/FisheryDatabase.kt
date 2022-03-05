package com.buaja.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.buaja.database.dao.ListDao
import com.buaja.database.dao.OptionsAreaDao
import com.buaja.database.dao.OptionsSizeDao
import com.buaja.database.entity.ListEntity
import com.buaja.database.entity.OptionsAreaEntity
import com.buaja.database.entity.OptionsSizeEntity


/**
 * @created 05/03/22 16.10
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Database(
    entities = [ListEntity::class, OptionsAreaEntity::class, OptionsSizeEntity::class],
    version = 1,
    exportSchema = false
)
abstract class FisheryDatabase : RoomDatabase() {
    abstract fun listDao(): ListDao
    abstract fun optionsAreaDao(): OptionsAreaDao
    abstract fun optionsSizeDao(): OptionsSizeDao
}
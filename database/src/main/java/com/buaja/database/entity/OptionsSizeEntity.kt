package com.buaja.database.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "options_size")
data class OptionsSizeEntity(
    @PrimaryKey
    @ColumnInfo(name = "size")
    val size: String
)
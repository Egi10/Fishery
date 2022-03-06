package com.buaja.database.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "options_area")
data class OptionsAreaEntity(
    @ColumnInfo(name = "city")
    val city: String,
    @PrimaryKey
    @ColumnInfo(name = "province")
    val province: String
)
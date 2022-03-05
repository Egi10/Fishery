package com.buaja.database.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "options_area")
data class OptionsAreaEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,
    @ColumnInfo(name = "city")
    val city: String,
    @ColumnInfo(name = "province")
    val province: String
)
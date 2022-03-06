package com.buaja.database.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list")
data class ListEntity(
    @ColumnInfo(name = "area_city")
    val areaCity: String,
    @ColumnInfo(name = "area_province")
    val areaProvince: String,
    @ColumnInfo(name = "commodity")
    val commodity: String,
    @ColumnInfo(name = "price")
    val price: String,
    @ColumnInfo(name = "size")
    val size: String,
    @ColumnInfo(name = "tgl_parsed")
    val tglParsed: String,
    @ColumnInfo(name = "timestamp")
    val timestamp: String,
    @PrimaryKey
    @ColumnInfo(name = "uuid")
    val uuid: String
)
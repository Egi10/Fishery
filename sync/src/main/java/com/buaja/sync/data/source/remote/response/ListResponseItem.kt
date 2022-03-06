package com.buaja.sync.data.source.remote.response


import com.squareup.moshi.Json

data class ListResponseItem(
    @field:Json(name = "area_kota")
    val areaCity: String?,
    @field:Json(name = "area_provinsi")
    val areaProvince: String?,
    @field:Json(name = "komoditas")
    val commodity: String?,
    @field:Json(name = "price")
    val price: String?,
    @field:Json(name = "size")
    val size: String?,
    @field:Json(name = "tgl_parsed")
    val tglParsed: String?,
    @field:Json(name = "timestamp")
    val timestamp: String?,
    @field:Json(name = "uuid")
    val uuid: String?
)
package com.buaja.sync.data.source.remote.response


import com.squareup.moshi.Json

data class OptionsAreaResponseItem(
    @field:Json(name = "city")
    val city: String,
    @field:Json(name = "province")
    val province: String
)
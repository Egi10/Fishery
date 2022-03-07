package com.buaja.home.data.source.remote.response


import com.squareup.moshi.Json

data class SaveResponse(
    @Json(name = "updatedRange")
    val updatedRange: String
)
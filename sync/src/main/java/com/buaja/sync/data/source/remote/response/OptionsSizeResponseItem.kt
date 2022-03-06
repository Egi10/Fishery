package com.buaja.sync.data.source.remote.response


import com.squareup.moshi.Json

data class OptionsSizeResponseItem(
    @field:Json(name = "size")
    val size: String
)
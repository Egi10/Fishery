package com.buaja.sync.data.source.remote.routes

import com.buaja.network.utils.ApiConstants
import com.buaja.sync.data.source.remote.response.ListResponseItem
import com.buaja.sync.data.source.remote.response.OptionsAreaResponseItem
import com.buaja.sync.data.source.remote.response.OptionsSizeResponseItem
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


/**
 * @created 06/03/22 09.52
 * @author Julsapargi Nursam
 * @project Fishery
 **/

interface FisheryService {
    @GET("{version}/{storage}/{key}/list")
    suspend fun getList(
        @Path("version") version: String = ApiConstants.version,
        @Path("storage") storage: String = ApiConstants.storage,
        @Path("key") key: String = ApiConstants.key
    ): List<ListResponseItem>

    @GET("{version}/{storage}/{key}/option_area")
    suspend fun getOptionsArea(
        @Path("version") version: String = ApiConstants.version,
        @Path("storage") storage: String = ApiConstants.storage,
        @Path("key") key: String = ApiConstants.key
    ): List<OptionsAreaResponseItem>

    @GET("{version}/{storage}/{key}/option_size")
    suspend fun getOptionsSize(
        @Path("version") version: String = ApiConstants.version,
        @Path("storage") storage: String = ApiConstants.storage,
        @Path("key") key: String = ApiConstants.key
    ): List<OptionsSizeResponseItem>
}
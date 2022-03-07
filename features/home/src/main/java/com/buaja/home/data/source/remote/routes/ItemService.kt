package com.buaja.home.data.source.remote.routes

import com.buaja.home.data.source.remote.response.SaveResponse
import com.buaja.network.utils.ApiConstants
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path


/**
 * @created 07/03/22 19.38
 * @author Julsapargi Nursam
 * @project Fishery
 **/

interface ItemService {
    @POST("{version}/{storage}/{key}/list")
    suspend fun saveNewItem(
        @Path("version") version: String = ApiConstants.version,
        @Path("storage") storage: String = ApiConstants.storage,
        @Path("key") key: String = ApiConstants.key,
        @Body post: Any?
    ): SaveResponse
}
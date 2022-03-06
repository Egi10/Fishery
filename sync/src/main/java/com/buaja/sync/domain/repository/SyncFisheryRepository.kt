package com.buaja.sync.domain.repository


/**
 * @created 06/03/22 10.19
 * @author Julsapargi Nursam
 * @project Fishery
 **/

interface SyncFisheryRepository {
    suspend fun syncData()
}
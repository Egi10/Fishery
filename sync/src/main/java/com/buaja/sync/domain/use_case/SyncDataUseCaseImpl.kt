package com.buaja.sync.domain.use_case

import com.buaja.sync.domain.repository.SyncFisheryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


/**
 * @created 07/03/22 05.59
 * @author Julsapargi Nursam
 * @project Fishery
 **/

class SyncDataUseCaseImpl @Inject constructor(
    private val syncFisheryRepository: SyncFisheryRepository
) : SyncDataUseCase {
    override fun invoke(): Flow<Unit> {
        return flow {
            emit(syncFisheryRepository.syncData())
        }
    }
}
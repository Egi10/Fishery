package com.buaja.sync.domain.use_case

import kotlinx.coroutines.flow.Flow


/**
 * @created 07/03/22 05.58
 * @author Julsapargi Nursam
 * @project Fishery
 **/

interface SyncDataUseCase {
    operator fun invoke(): Flow<Unit>
}
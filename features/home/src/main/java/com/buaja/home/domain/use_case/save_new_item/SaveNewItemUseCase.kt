package com.buaja.home.domain.use_case.save_new_item

import com.buaja.home.domain.model.NewItemRequest
import kotlinx.coroutines.flow.Flow


/**
 * @created 07/03/22 19.31
 * @author Julsapargi Nursam
 * @project Fishery
 **/

interface SaveNewItemUseCase {
    operator fun invoke(netItemRequest: NewItemRequest): Flow<String>
}
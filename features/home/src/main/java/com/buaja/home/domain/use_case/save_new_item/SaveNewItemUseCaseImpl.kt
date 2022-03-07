package com.buaja.home.domain.use_case.save_new_item

import com.buaja.home.domain.model.NewItemRequest
import com.buaja.home.domain.repository.ListPriceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 * @created 07/03/22 19.32
 * @author Julsapargi Nursam
 * @project Fishery
 **/

class SaveNewItemUseCaseImpl @Inject constructor(
    private val listPriceRepository: ListPriceRepository
) : SaveNewItemUseCase {
    override fun invoke(netItemRequest: NewItemRequest): Flow<String> {
        return listPriceRepository.saveNewItem(netItemRequest)
    }
}
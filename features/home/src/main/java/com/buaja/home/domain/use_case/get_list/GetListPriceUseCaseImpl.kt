package com.buaja.home.domain.use_case.get_list

import com.buaja.home.domain.model.ListPrice
import com.buaja.home.domain.repository.ListPriceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 * @created 06/03/22 15.42
 * @author Julsapargi Nursam
 * @project Fishery
 **/

class GetListPriceUseCaseImpl @Inject constructor(
    private val listPriceRepository: ListPriceRepository
) : GetListPriceUseCase {
    override fun invoke(): Flow<List<ListPrice>> {
        return listPriceRepository.getAllList()
    }
}
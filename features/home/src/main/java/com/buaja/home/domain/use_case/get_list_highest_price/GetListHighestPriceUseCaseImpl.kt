package com.buaja.home.domain.use_case.get_list_highest_price

import com.buaja.home.domain.model.ListPrice
import com.buaja.home.domain.repository.ListPriceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 * @created 07/03/22 06.49
 * @author Julsapargi Nursam
 * @project Fishery
 **/

class GetListHighestPriceUseCaseImpl @Inject constructor(
    private val listPriceRepository: ListPriceRepository
) : GetListHighestPriceUseCase {
    override fun invoke(): Flow<List<ListPrice>> {
        return listPriceRepository.getAllListByHighestPrice()
    }
}
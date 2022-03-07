package com.buaja.home.domain.use_case.get_list_lowest_price

import com.buaja.home.domain.model.ListPrice
import com.buaja.home.domain.repository.ListPriceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 * @created 07/03/22 05.41
 * @author Julsapargi Nursam
 * @project Fishery
 **/

class GetListLowestPriceUseCaseImpl @Inject constructor(
    private val listPriceRepository: ListPriceRepository
) : GetListLowestPriceUseCase {
    override fun invoke(): Flow<List<ListPrice>> {
        return listPriceRepository.getAllListByLowestPrice()
    }
}
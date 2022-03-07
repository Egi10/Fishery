package com.buaja.home.domain.use_case.get_list_lowest_size

import com.buaja.home.domain.model.ListPrice
import com.buaja.home.domain.repository.ListPriceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 * @created 07/03/22 06.52
 * @author Julsapargi Nursam
 * @project Fishery
 **/

class GetListLowesSizeUseCaseImpl @Inject constructor(
    private val listPriceRepository: ListPriceRepository
) : GetListLowestSizeUseCase {
    override fun invoke(): Flow<List<ListPrice>> {
        return listPriceRepository.getAllListByLowestSize()
    }
}
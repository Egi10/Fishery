package com.buaja.home.domain.use_case.get_list_commodity

import com.buaja.home.domain.model.ListPrice
import com.buaja.home.domain.repository.ListPriceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 * @created 07/03/22 08.48
 * @author Julsapargi Nursam
 * @project Fishery
 **/

class GetListCommodityUseCaseImpl @Inject constructor(
    private val listPriceRepository: ListPriceRepository
) : GetListCommodityUseCase {
    override fun invoke(commodity: String): Flow<List<ListPrice>> {
        return listPriceRepository.getListByCommodity(commodity)
    }
}
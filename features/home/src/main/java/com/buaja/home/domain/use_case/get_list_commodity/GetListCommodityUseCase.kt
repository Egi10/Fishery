package com.buaja.home.domain.use_case.get_list_commodity

import com.buaja.home.domain.model.ListPrice
import kotlinx.coroutines.flow.Flow


/**
 * @created 07/03/22 08.47
 * @author Julsapargi Nursam
 * @project Fishery
 **/

interface GetListCommodityUseCase {
    operator fun invoke(commodity: String): Flow<List<ListPrice>>
}
package com.buaja.home.domain.use_case.get_list_lowest_price

import com.buaja.home.domain.model.ListPrice
import kotlinx.coroutines.flow.Flow


/**
 * @created 07/03/22 05.40
 * @author Julsapargi Nursam
 * @project Fishery
 **/

interface GetListLowestPriceUseCase {
    operator fun invoke(): Flow<List<ListPrice>>
}
package com.buaja.home.domain.use_case.get_list

import com.buaja.home.domain.model.ListPrice
import kotlinx.coroutines.flow.Flow


/**
 * @created 06/03/22 15.41
 * @author Julsapargi Nursam
 * @project Fishery
 **/

interface GetListPriceUseCase {
    operator fun invoke(): Flow<List<ListPrice>>
}
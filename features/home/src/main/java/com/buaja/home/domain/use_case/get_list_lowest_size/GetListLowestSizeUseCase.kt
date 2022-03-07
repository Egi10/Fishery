package com.buaja.home.domain.use_case.get_list_lowest_size

import com.buaja.home.domain.model.ListPrice
import kotlinx.coroutines.flow.Flow


/**
 * @created 07/03/22 06.51
 * @author Julsapargi Nursam
 * @project Fishery
 **/

interface GetListLowestSizeUseCase {
    operator fun invoke(): Flow<List<ListPrice>>
}
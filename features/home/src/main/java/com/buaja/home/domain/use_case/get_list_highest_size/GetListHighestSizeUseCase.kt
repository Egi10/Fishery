package com.buaja.home.domain.use_case.get_list_highest_size

import com.buaja.home.domain.model.ListPrice
import kotlinx.coroutines.flow.Flow


/**
 * @created 07/03/22 06.54
 * @author Julsapargi Nursam
 * @project Fishery
 **/

interface GetListHighestSizeUseCase {
    operator fun invoke(): Flow<List<ListPrice>>
}
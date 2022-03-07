package com.buaja.home.domain.use_case.get_list_area_province

import com.buaja.home.domain.model.ListPrice
import kotlinx.coroutines.flow.Flow


/**
 * @created 07/03/22 18.26
 * @author Julsapargi Nursam
 * @project Fishery
 **/

interface GetListAreaProvince {
    operator fun invoke(areaProvince: String): Flow<List<ListPrice>>
}
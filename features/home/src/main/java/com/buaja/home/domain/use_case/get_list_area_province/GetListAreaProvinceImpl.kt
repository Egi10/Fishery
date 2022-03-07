package com.buaja.home.domain.use_case.get_list_area_province

import com.buaja.home.domain.model.ListPrice
import com.buaja.home.domain.repository.ListPriceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 * @created 07/03/22 18.27
 * @author Julsapargi Nursam
 * @project Fishery
 **/

class GetListAreaProvinceImpl @Inject constructor(
    private val listPriceRepository: ListPriceRepository
) : GetListAreaProvince {
    override fun invoke(areaProvince: String): Flow<List<ListPrice>> {
        return listPriceRepository.getListByAreaProvince(areaProvince)
    }
}
package com.buaja.home.domain.use_case.get_list_options_area

import kotlinx.coroutines.flow.Flow


/**
 * @created 07/03/22 17.56
 * @author Julsapargi Nursam
 * @project Fishery
 **/

interface GetListOptionsAreaUseCase {
 operator fun invoke(): Flow<List<String>>
}
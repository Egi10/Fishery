package com.buaja.home.domain.use_case.get_list_options_area

import com.buaja.home.domain.repository.OptionsAreaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 * @created 07/03/22 17.58
 * @author Julsapargi Nursam
 * @project Fishery
 **/

class GetListOptionsAreaUseCaseImpl @Inject constructor(
    private val optionsAreaRepository: OptionsAreaRepository
) : GetListOptionsAreaUseCase {
    override fun invoke(): Flow<List<String>> {
        return optionsAreaRepository.getAllOptionsArea()
    }
}
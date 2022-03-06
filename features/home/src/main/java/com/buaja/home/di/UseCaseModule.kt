package com.buaja.home.di

import com.buaja.home.domain.use_case.get_list.GetListPriceUseCase
import com.buaja.home.domain.use_case.get_list.GetListPriceUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


/**
 * @created 06/03/22 15.45
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    @ViewModelScoped
    abstract fun bindsGetListPriceUseCase(
        getListPriceUseCaseImpl: GetListPriceUseCaseImpl
    ): GetListPriceUseCase
}
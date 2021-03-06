package com.buaja.home.di

import com.buaja.home.domain.use_case.get_list.GetListPriceUseCase
import com.buaja.home.domain.use_case.get_list.GetListPriceUseCaseImpl
import com.buaja.home.domain.use_case.get_list_area_province.GetListAreaProvince
import com.buaja.home.domain.use_case.get_list_area_province.GetListAreaProvinceImpl
import com.buaja.home.domain.use_case.get_list_commodity.GetListCommodityUseCase
import com.buaja.home.domain.use_case.get_list_commodity.GetListCommodityUseCaseImpl
import com.buaja.home.domain.use_case.get_list_highest_price.GetListHighestPriceUseCase
import com.buaja.home.domain.use_case.get_list_highest_price.GetListHighestPriceUseCaseImpl
import com.buaja.home.domain.use_case.get_list_highest_size.GetListHighestSizeUseCase
import com.buaja.home.domain.use_case.get_list_highest_size.GetListHighestSizeUseCaseImpl
import com.buaja.home.domain.use_case.get_list_lowest_price.GetListLowestPriceUseCase
import com.buaja.home.domain.use_case.get_list_lowest_price.GetListLowestPriceUseCaseImpl
import com.buaja.home.domain.use_case.get_list_lowest_size.GetListLowesSizeUseCaseImpl
import com.buaja.home.domain.use_case.get_list_lowest_size.GetListLowestSizeUseCase
import com.buaja.home.domain.use_case.get_list_options_area.GetListOptionsAreaUseCase
import com.buaja.home.domain.use_case.get_list_options_area.GetListOptionsAreaUseCaseImpl
import com.buaja.home.domain.use_case.save_new_item.SaveNewItemUseCase
import com.buaja.home.domain.use_case.save_new_item.SaveNewItemUseCaseImpl
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

    @Binds
    @ViewModelScoped
    abstract fun bindsGetListLowestPriceUseCase(
        getListLowestPriceImpl: GetListLowestPriceUseCaseImpl
    ): GetListLowestPriceUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetListHighestPriceUseCase(
        getListHighestPriceImpl: GetListHighestPriceUseCaseImpl
    ): GetListHighestPriceUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetListHighestSize(
        getListHighestSizeUseCaseImpl: GetListHighestSizeUseCaseImpl
    ): GetListHighestSizeUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetListLowestSize(
        getListLowesSizeUseCaseImpl: GetListLowesSizeUseCaseImpl
    ): GetListLowestSizeUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetListCommodityUseCase(
        getListCommodityUseCaseImpl: GetListCommodityUseCaseImpl
    ): GetListCommodityUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindsGetListOptionsAreaUseCase(
        getListOptionsAreaUseCaseImpl: GetListOptionsAreaUseCaseImpl
    ): GetListOptionsAreaUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindsGetListAreaProvinceUseCase(
        getListAreaProvinceImpl: GetListAreaProvinceImpl
    ): GetListAreaProvince

    @Binds
    @ViewModelScoped
    abstract fun bindsSaveNewItemUseCase(
        saveNewItemUseCaseImpl: SaveNewItemUseCaseImpl
    ): SaveNewItemUseCase
}
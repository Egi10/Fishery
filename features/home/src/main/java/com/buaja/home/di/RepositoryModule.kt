package com.buaja.home.di

import com.buaja.home.data.repository.ListPriceRepositoryImpl
import com.buaja.home.domain.repository.ListPriceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * @created 06/03/22 15.44
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsListPriceRepository(
        listPriceRepositoryImpl: ListPriceRepositoryImpl
    ): ListPriceRepository
}
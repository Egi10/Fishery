package com.buaja.home.di

import com.buaja.home.data.source.remote.routes.ItemService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


/**
 * @created 07/03/22 19.43
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Module
@InstallIn(SingletonComponent::class)
class ApiServiceHomeModule {
    @Provides
    @Singleton
    fun provideFisheryService(retrofit: Retrofit): ItemService =
        retrofit.create(ItemService::class.java)
}
package com.buaja.sync.di

import com.buaja.sync.data.source.remote.routes.FisheryService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


/**
 * @created 06/03/22 09.41
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Module
@InstallIn(SingletonComponent::class)
class ApiServiceModule {
    @Provides
    @Singleton
    fun provideFisheryService(retrofit: Retrofit): FisheryService =
        retrofit.create(FisheryService::class.java)
}
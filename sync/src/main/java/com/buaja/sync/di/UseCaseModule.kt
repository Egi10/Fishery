package com.buaja.sync.di

import com.buaja.sync.domain.use_case.SyncDataUseCase
import com.buaja.sync.domain.use_case.SyncDataUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * @created 07/03/22 05.59
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun bindSyncDataUseCase(
        syncDataUseCaseImpl: SyncDataUseCaseImpl
    ): SyncDataUseCase
}
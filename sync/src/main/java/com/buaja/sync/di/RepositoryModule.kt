package com.buaja.sync.di

import com.buaja.sync.data.repository.SyncFisheryRepositoryImp
import com.buaja.sync.domain.repository.SyncFisheryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * @created 06/03/22 10.43
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindSyncFisheryRepository(
        syncFisheryRepositoryImp: SyncFisheryRepositoryImp
    ): SyncFisheryRepository
}
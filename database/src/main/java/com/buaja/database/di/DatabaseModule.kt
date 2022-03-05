package com.buaja.database.di

import android.content.Context
import androidx.room.Room
import com.buaja.database.db.FisheryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * @created 05/03/22 16.13
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        FisheryDatabase::class.java, "fishery.db"
    ).build()

    @Provides
    @Singleton
    fun provideListDao(database: FisheryDatabase) = database.listDao()

    @Provides
    @Singleton
    fun provideOptionAreaDao(database: FisheryDatabase) = database.optionsAreaDao()

    @Provides
    @Singleton
    fun provideOptionSizeDao(database: FisheryDatabase) = database.optionsSizeDao()
}
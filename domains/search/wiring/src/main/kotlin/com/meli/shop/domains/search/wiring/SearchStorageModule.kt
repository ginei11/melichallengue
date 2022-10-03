package com.meli.shop.domains.search.wiring

import android.content.Context
import androidx.room.Room
import com.meli.shop.domains.search.impl.database.SearchDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SearchStorageModule {

    @Provides
    fun provideStorage(
        @ApplicationContext context: Context
    ): SearchDatabase = Room.databaseBuilder(
        context,
        SearchDatabase::class.java,
        "meli-db"
    ).build()
}

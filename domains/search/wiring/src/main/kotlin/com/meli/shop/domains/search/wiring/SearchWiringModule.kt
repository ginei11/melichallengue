package com.meli.shop.domains.search.wiring

import com.meli.shop.domains.search.api.repository.SearchRepository
import com.meli.shop.domains.search.api.usecases.GetLocalSearchUC
import com.meli.shop.domains.search.api.usecases.GetRemoteSearchUC
import com.meli.shop.domains.search.impl.repositories.SearchRepositoryImpl
import com.meli.shop.domains.search.impl.services.SearchService
import com.meli.shop.domains.search.impl.usecases.GetLocalSearchUCImpl
import com.meli.shop.domains.search.impl.usecases.GetRemoteSearchUCImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SearchWiringModule {

    @Binds
    abstract fun bindGetRemoteSearchUC(useCase: GetRemoteSearchUCImpl): GetRemoteSearchUC

    @Binds
    abstract fun bindGetLocalSearchUC(useCase: GetLocalSearchUCImpl): GetLocalSearchUC

    @Binds
    abstract fun bindSearchRepository(useCase: SearchRepositoryImpl): SearchRepository

    companion object {
        @Provides
        @Singleton
        fun providesSearchService(
            retrofit: Retrofit
        ): SearchService {
            return retrofit.create(SearchService::class.java)
        }
    }
}

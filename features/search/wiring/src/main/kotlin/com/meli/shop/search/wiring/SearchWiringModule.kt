package com.meli.shop.search.wiring

import com.meli.shop.common.navigation.AggregateFeatureEntry
import com.meli.shop.search.api.SearchFeatureNavGraph
import com.meli.shop.search.impl.navigation.SearchFeatureNavGraphImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
abstract class SearchWiringModule {

    @IntoSet
    @Binds
    abstract fun bindNavGraph(navGraphImpl: SearchFeatureNavGraphImpl): AggregateFeatureEntry

    @Binds
    abstract fun bindFeatureNavGraph(navGraphImpl: SearchFeatureNavGraphImpl): SearchFeatureNavGraph
}

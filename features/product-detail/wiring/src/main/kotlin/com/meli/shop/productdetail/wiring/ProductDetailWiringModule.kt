package com.meli.shop.productdetail.wiring

import com.meli.shop.common.navigation.AggregateFeatureEntry
import com.meli.shop.productdetail.api.ProductDetailFeatureNavGraph
import com.meli.shop.productdetail.impl.ProductDetailFeatureNavGraphImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductDetailWiringModule {

    @IntoSet
    @Binds
    abstract fun bindNavGraph(navGraphImpl: ProductDetailFeatureNavGraphImpl): AggregateFeatureEntry

    @Binds
    abstract fun bindFeatureNavGraph(navGraphImpl: ProductDetailFeatureNavGraphImpl): ProductDetailFeatureNavGraph
}

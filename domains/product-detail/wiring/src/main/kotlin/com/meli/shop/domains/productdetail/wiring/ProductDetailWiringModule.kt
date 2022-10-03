package com.meli.shop.domains.productdetail.wiring

import com.meli.shop.domains.productdetail.api.repository.ProductDetailRepository
import com.meli.shop.domains.productdetail.api.usecases.GetProductDetailUC
import com.meli.shop.domains.productdetail.impl.repositories.ProductDetailRepositoryImpl
import com.meli.shop.domains.productdetail.impl.services.ProductDetailService
import com.meli.shop.domains.productdetail.impl.usecases.GetProductDetailUCImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductDetailWiringModule {

    @Binds
    abstract fun bindGetProductDetailUC(useCase: GetProductDetailUCImpl): GetProductDetailUC

    @Binds
    abstract fun bindProductDetailRepository(useCase: ProductDetailRepositoryImpl): ProductDetailRepository

    companion object {
        @Provides
        @Singleton
        fun providesProductDetailService(
            retrofit: Retrofit
        ): ProductDetailService {
            return retrofit.create(ProductDetailService::class.java)
        }
    }
}

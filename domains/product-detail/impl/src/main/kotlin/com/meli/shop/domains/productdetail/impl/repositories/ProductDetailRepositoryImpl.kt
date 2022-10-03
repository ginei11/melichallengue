package com.meli.shop.domains.productdetail.impl.repositories

import com.meli.shop.domains.productdetail.api.models.ProductDetailUIStates
import com.meli.shop.domains.productdetail.api.repository.ProductDetailRepository
import com.meli.shop.domains.productdetail.impl.services.ProductDetailService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductDetailRepositoryImpl @Inject constructor(
    private val service: ProductDetailService
) : ProductDetailRepository {

    override suspend fun getProductDetail(productId: String): Flow<ProductDetailUIStates> {
        return flow {
            val response = service.getProductDetail(productId)
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(ProductDetailUIStates.Success(it))
                }
            } else {
                emit(ProductDetailUIStates.Error)
            }
        }
    }
}

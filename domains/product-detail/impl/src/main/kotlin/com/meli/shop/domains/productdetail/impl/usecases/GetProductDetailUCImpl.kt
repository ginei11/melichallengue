package com.meli.shop.domains.productdetail.impl.usecases

import com.meli.shop.domains.productdetail.api.models.ProductDetailUIStates
import com.meli.shop.domains.productdetail.api.repository.ProductDetailRepository
import com.meli.shop.domains.productdetail.api.usecases.GetProductDetailUC
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class GetProductDetailUCImpl @Inject constructor(
    private val repository: ProductDetailRepository
) : GetProductDetailUC {

    override suspend fun invoke(productId: String): Flow<ProductDetailUIStates> {
        return repository.getProductDetail(productId).onStart {
            emit(ProductDetailUIStates.Loading)
        }.catch {
            emit(ProductDetailUIStates.Error)
        }.flowOn(Dispatchers.IO)
    }
}

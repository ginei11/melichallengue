package com.meli.shop.domains.productdetail.api.usecases

import com.meli.shop.domains.productdetail.api.models.ProductDetailUIStates
import kotlinx.coroutines.flow.Flow

interface GetProductDetailUC {
    suspend operator fun invoke(productId: String): Flow<ProductDetailUIStates>
}

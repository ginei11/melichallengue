package com.meli.shop.domains.productdetail.api.repository

import com.meli.shop.domains.productdetail.api.models.ProductDetailUIStates
import kotlinx.coroutines.flow.Flow

interface ProductDetailRepository {

    suspend fun getProductDetail(productId: String): Flow<ProductDetailUIStates>
}

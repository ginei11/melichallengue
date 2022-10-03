package com.meli.shop.domains.productdetail.api.models

sealed class ProductDetailUIStates {
    object Loading : ProductDetailUIStates()
    object Error : ProductDetailUIStates()
    class Success(
        val product: ProductDetailModel
    ) : ProductDetailUIStates()
}

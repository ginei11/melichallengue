package com.meli.shop.productdetail.api

import com.meli.shop.common.navigation.AggregateFeatureEntry

interface ProductDetailFeatureNavGraph : AggregateFeatureEntry {

    fun productDetailRoute(productId: String): String
}

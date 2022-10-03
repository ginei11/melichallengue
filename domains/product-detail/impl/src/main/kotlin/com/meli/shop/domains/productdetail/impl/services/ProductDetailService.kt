package com.meli.shop.domains.productdetail.impl.services

import com.meli.shop.domains.productdetail.api.models.ProductDetailModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductDetailService {

    @GET("items/{productId}")
    suspend fun getProductDetail(@Path(value = "productId") productId: String): Response<ProductDetailModel>
}

package com.meli.shop.domains.search.impl.services

import com.meli.shop.domains.search.api.models.ProductSearchResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {

    @GET("/sites/MLM/search?")
    suspend fun search(@Query("q") query: String): Response<ProductSearchResponseModel>
}

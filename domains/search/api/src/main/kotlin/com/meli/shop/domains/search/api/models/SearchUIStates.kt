package com.meli.shop.domains.search.api.models

sealed class SearchUIStates {
    object Loading : SearchUIStates()
    object DataZero : SearchUIStates()
    object Error : SearchUIStates()
    class Success(
        val items: List<ProductSearchSearchModel>
    ) : SearchUIStates()
}

package com.meli.shop.domains.search.impl.repositories

import com.meli.shop.domains.search.api.models.SearchUIStates
import com.meli.shop.domains.search.api.repository.SearchRepository
import com.meli.shop.domains.search.impl.services.SearchService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchService: SearchService
) : SearchRepository {

    override suspend fun search(value: String): Flow<SearchUIStates> {
        return flow {
            val response = searchService.search(value)
            if (response.isSuccessful) {
                response.body()?.let {
                    if (it.products.isNotEmpty()) {
                        emit(
                            SearchUIStates.Success(it.products)
                        )
                    } else {
                        emit(SearchUIStates.Error)
                    }
                }
            } else {
                emit(SearchUIStates.Error)
            }
        }
    }
}

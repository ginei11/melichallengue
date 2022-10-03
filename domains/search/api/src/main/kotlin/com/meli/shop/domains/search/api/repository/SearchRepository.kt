package com.meli.shop.domains.search.api.repository

import com.meli.shop.domains.search.api.models.SearchUIStates
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    suspend fun search(value: String): Flow<SearchUIStates>
}

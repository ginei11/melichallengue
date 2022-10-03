package com.meli.shop.domains.search.api.usecases

import com.meli.shop.domains.search.api.models.SearchUIStates
import kotlinx.coroutines.flow.Flow

interface GetRemoteSearchUC {
    suspend operator fun invoke(value: String): Flow<SearchUIStates>
}

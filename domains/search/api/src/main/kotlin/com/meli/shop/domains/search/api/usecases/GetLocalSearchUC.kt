package com.meli.shop.domains.search.api.usecases

import kotlinx.coroutines.flow.Flow

interface GetLocalSearchUC {
    suspend operator fun invoke(value: String): Flow<List<String>>
}

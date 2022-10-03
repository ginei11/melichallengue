package com.meli.shop.domains.search.impl.usecases

import com.meli.shop.domains.search.api.models.SearchUIStates
import com.meli.shop.domains.search.api.repository.SearchRepository
import com.meli.shop.domains.search.api.usecases.GetRemoteSearchUC
import com.meli.shop.domains.search.impl.database.RecentSearchEntity
import com.meli.shop.domains.search.impl.database.SearchDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class GetRemoteSearchUCImpl @Inject constructor(
    private val repository: SearchRepository,
    private val database: SearchDatabase
) : GetRemoteSearchUC {

    override suspend fun invoke(value: String): Flow<SearchUIStates> {
        return repository.search(value).onEach {
            if (it is SearchUIStates.Success) {
                // Save recent search
                database.recentSearchDao().addRecentSearchValue(
                    RecentSearchEntity(value)
                )
            }
        }.onStart {
            emit(SearchUIStates.Loading)
        }.catch {
            emit(SearchUIStates.Error)
        }.flowOn(Dispatchers.IO)
    }
}

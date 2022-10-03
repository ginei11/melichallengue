package com.meli.shop.domains.search.impl.usecases

import com.meli.shop.domains.search.api.usecases.GetLocalSearchUC
import com.meli.shop.domains.search.impl.database.SearchDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetLocalSearchUCImpl @Inject constructor(private val database: SearchDatabase) :
    GetLocalSearchUC {

    override suspend fun invoke(value: String): Flow<List<String>> {
        return flow {
            withContext(Dispatchers.IO) {
                database.recentSearchDao().loadRecentSearchByValue(value)
            }
        }
    }
}

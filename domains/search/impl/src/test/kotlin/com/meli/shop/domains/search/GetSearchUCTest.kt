package com.meli.shop.domains.search

import com.meli.shop.domains.search.api.models.SearchUIStates
import com.meli.shop.domains.search.api.repository.SearchRepository
import com.meli.shop.domains.search.impl.database.SearchDatabase
import com.meli.shop.domains.search.impl.usecases.GetRemoteSearchUCImpl
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetSearchUCTest {

    @MockK
    lateinit var repository: SearchRepository

    @MockK
    lateinit var searchDatabase: SearchDatabase

    @MockK
    lateinit var successAction: SearchUIStates.Success

    private lateinit var getRemoteSearchUC: GetRemoteSearchUCImpl

    private val query = "query"

    @Before
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
        MockKAnnotations.init(this, relaxed = true, relaxUnitFun = true)
        getRemoteSearchUC = GetRemoteSearchUCImpl(repository, searchDatabase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun invokingUCRetrievesSearchReturnLoading() = runTest {
        coEvery { repository.search(query) } returns flow { emit(successAction) }
        assert(getRemoteSearchUC.invoke(String()).first() is SearchUIStates.Loading)
    }

    @Test
    fun invokingUCRetrievesSearchReturnAnError() = runTest {
        coEvery { repository.search(query) } returns flow { throw RuntimeException("Crash!") }
        assert(getRemoteSearchUC.invoke(query).last() is SearchUIStates.Error)
    }

    @Test
    fun invokingUCRetrievesSearchReturnSuccess() = runTest {
        coEvery { repository.search(query) } returns flow { emit(successAction) }
        assert(getRemoteSearchUC.invoke(query).last() is SearchUIStates.Success)
    }
}

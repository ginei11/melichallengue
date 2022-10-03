package com.meli.shop.domains.search

import com.meli.shop.domains.search.api.models.ProductSearchResponseModel
import com.meli.shop.domains.search.api.models.ProductSearchSearchModel
import com.meli.shop.domains.search.api.models.SearchUIStates
import com.meli.shop.domains.search.impl.repositories.SearchRepositoryImpl
import com.meli.shop.domains.search.impl.services.SearchService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class SearchRepositoryTest {

    @MockK
    lateinit var searchService: SearchService

    private lateinit var searchRepositoryImpl: SearchRepositoryImpl


    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true, relaxUnitFun = true)
        searchRepositoryImpl = SearchRepositoryImpl(
            searchService
        )
    }

    @Test
    fun errorShouldReturnWhenResponseIsNotSuccess() = runTest {
        coEvery { searchService.search(String()) } returns Response.success(
            200,
            ProductSearchResponseModel(String(), emptyList())
        )

        val result = searchRepositoryImpl.search(String()).first()
        assert(result is SearchUIStates.Error)
    }

    @Test
    fun shouldReturnSuccess() = runTest {
        val mockResponse = mockk<ProductSearchResponseModel>()

        val products = mockk<ProductSearchSearchModel>()
        every { mockResponse.products } returns listOf(products)

        coEvery { searchService.search(String()) } returns Response.success(
            200,
            mockResponse
        )
        val result = searchRepositoryImpl.search(String()).first()
        assert(result is SearchUIStates.Success)
    }
}

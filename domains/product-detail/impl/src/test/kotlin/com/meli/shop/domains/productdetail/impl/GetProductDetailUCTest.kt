package com.meli.shop.domains.productdetail.impl

import com.meli.shop.domains.productdetail.api.models.ProductDetailUIStates
import com.meli.shop.domains.productdetail.api.repository.ProductDetailRepository
import com.meli.shop.domains.productdetail.impl.usecases.GetProductDetailUCImpl
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
class GetProductDetailUCTest {

    @MockK
    lateinit var repository: ProductDetailRepository

    @MockK
    lateinit var errorAction: ProductDetailUIStates.Error

    @MockK
    lateinit var successAction: ProductDetailUIStates.Success

    lateinit var getProductDetailUC: GetProductDetailUCImpl

    private val productId = "productId"

    @Before
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
        MockKAnnotations.init(this, relaxed = true, relaxUnitFun = true)
        getProductDetailUC = GetProductDetailUCImpl(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun invokingUCRetrievesProductDetailReturnLoading() = runTest {
        coEvery { repository.getProductDetail(productId) } returns flow { emit(errorAction) }
        assert(getProductDetailUC.invoke(String()).first() is ProductDetailUIStates.Loading)
    }

    @Test
    fun invokingUCRetrievesProductDetailReturnAnError() = runTest {
        coEvery { repository.getProductDetail(productId) } returns flow { throw RuntimeException("Crash!") }
        assert(getProductDetailUC.invoke(productId).last() is ProductDetailUIStates.Error)
    }

    @Test
    fun invokingUCRetrievesProductDetailReturnSuccess() = runTest {
        coEvery { repository.getProductDetail(productId) } returns flow { emit(successAction) }
        assert(getProductDetailUC.invoke(productId).last() is ProductDetailUIStates.Success)
    }
}

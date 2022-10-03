package com.meli.shop.domains.productdetail.impl

import com.meli.shop.domains.productdetail.api.models.ProductDetailModel
import com.meli.shop.domains.productdetail.api.models.ProductDetailUIStates
import com.meli.shop.domains.productdetail.impl.repositories.ProductDetailRepositoryImpl
import com.meli.shop.domains.productdetail.impl.services.ProductDetailService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class ProductDetailRepositoryTest {

    @MockK
    lateinit var service: ProductDetailService

    private lateinit var productDetailRepositoryImpl: ProductDetailRepositoryImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true, relaxUnitFun = true)
        productDetailRepositoryImpl = ProductDetailRepositoryImpl(
            service
        )
    }

    @Test
    fun invokingServiceProductDetailReturnSuccess() = runTest {
        val mockResponse = mockk<ProductDetailModel>()
        coEvery { service.getProductDetail(String()) } returns Response.success(
            200,
            mockResponse
        )

        val result = productDetailRepositoryImpl.getProductDetail(String()).first()
        assert(result is ProductDetailUIStates.Success)
    }
}

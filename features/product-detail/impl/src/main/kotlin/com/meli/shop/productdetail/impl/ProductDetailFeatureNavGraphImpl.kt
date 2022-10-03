package com.meli.shop.productdetail.impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.meli.shop.productdetail.api.ProductDetailFeatureNavGraph
import com.meli.shop.productdetail.impl.presentation.pages.ProductDetailPage
import javax.inject.Inject

class ProductDetailFeatureNavGraphImpl @Inject constructor() : ProductDetailFeatureNavGraph {

    private val featureRoute = "$ROUTE?$ARG_PRODUCT_ID={$ARG_PRODUCT_ID}"

    override fun productDetailRoute(productId: String): String = "$ROUTE?$ARG_PRODUCT_ID=$productId"

    override fun registerNavigation(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(featureRoute) {
            ProductDetailPage()
        }
    }

    companion object {
        const val ROUTE = "product-detail"
        const val ARG_PRODUCT_ID = "product-id"
    }
}

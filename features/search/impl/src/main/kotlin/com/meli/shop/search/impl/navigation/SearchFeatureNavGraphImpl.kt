package com.meli.shop.search.impl.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.meli.shop.productdetail.api.ProductDetailFeatureNavGraph
import com.meli.shop.search.api.SearchFeatureNavGraph
import com.meli.shop.search.impl.presentation.pages.SearchPage
import javax.inject.Inject

class SearchFeatureNavGraphImpl @Inject constructor(
    private val productDetailFeatureNavGraph: ProductDetailFeatureNavGraph
) : SearchFeatureNavGraph {

    override fun searchRoute(): String = "search"

    override fun registerNavigation(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(searchRoute()) {
            SearchPage(onProductClick = {
                navController.navigate(productDetailFeatureNavGraph.productDetailRoute(it))
            })
        }
    }
}

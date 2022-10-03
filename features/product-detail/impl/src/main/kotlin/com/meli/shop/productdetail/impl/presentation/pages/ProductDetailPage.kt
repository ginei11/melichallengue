package com.meli.shop.productdetail.impl.presentation.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.meli.shop.designsystem.atoms.DSLoader
import com.meli.shop.domains.productdetail.api.models.ProductDetailUIStates
import com.meli.shop.productdetail.impl.presentation.viewmodels.ProductDetailViewModel
import com.meli.shop.productdetail.impl.presentation.widgets.ProductDetailContent
import com.meli.shop.productdetail.impl.presentation.widgets.ProductErrorView

@Composable
fun ProductDetailPage(viewModel: ProductDetailViewModel = hiltViewModel()) {

    val state by viewModel.state.collectAsState()
    when (state) {
        ProductDetailUIStates.Loading -> DSLoader()
        ProductDetailUIStates.Error -> ProductErrorView()
        is ProductDetailUIStates.Success -> {
            ProductDetailContent((state as ProductDetailUIStates.Success).product)
        }
    }
}

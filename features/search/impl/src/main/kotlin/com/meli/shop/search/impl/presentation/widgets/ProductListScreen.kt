package com.meli.shop.search.impl.presentation.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.meli.shop.designsystem.utils.performHapticFeedback
import com.meli.shop.domains.search.api.models.ProductSearchSearchModel

@Composable
fun ProductListScreen(
    modifier: Modifier = Modifier,
    products: List<ProductSearchSearchModel>,
    onProductClick: (productId: String) -> Unit,
) {
    val context = LocalContext.current
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(10.dp),
    ) {
        items(items = products) { product ->
            ProductItemView(
                modifier = Modifier.clickable {
                    context.performHapticFeedback()
                    onProductClick.invoke(product.id)
                },
                product = product
            )
        }
    }
}

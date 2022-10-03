package com.meli.shop.search.impl.presentation.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.meli.shop.designsystem.atoms.DSText
import com.meli.shop.designsystem.atoms.TypographyType
import com.meli.shop.designsystem.theme.OnBackgroundColor
import com.meli.shop.designsystem.theme.SuccessColor
import com.meli.shop.designsystem.utils.DesignSystemDimen
import com.meli.shop.domains.search.api.models.ProductSearchSearchModel
import com.meli.shop.organism.ProductImage
import com.meli.shop.search.impl.R
import java.text.NumberFormat

@Composable
fun ProductItemView(
    modifier: Modifier = Modifier,
    product: ProductSearchSearchModel
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.Center) {
        Card(
            modifier = Modifier
                .size(100.dp),
            shape = RoundedCornerShape(percent = 10),
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.secondary)
        ) {
            ProductImage(
                modifier = Modifier.size(dimensionResource(id = DesignSystemDimen.view_size_104)),
                id = product.id,
                thumbnail = product.thumbnail
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .height(dimensionResource(id = DesignSystemDimen.view_size_112))
                .padding(dimensionResource(id = DesignSystemDimen.spacing_2)),
            verticalArrangement = Arrangement.Center
        ) {

            DSText(text = product.title, type = TypographyType.Caption, maxLines = 2)

            product.productPrices?.let {
                it.prices.first().let { item ->
                    if (item.amount < product.price) {
                        DSText(
                            text = item.amount.priceToString(),
                            type = TypographyType.Caption,
                            maxLines = 2,
                            modifier = Modifier
                                .padding(top = 5.dp)
                                .weight(2f)
                                .fillMaxWidth(),
                            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
                            textDecoration = TextDecoration.LineThrough
                        )
                    }
                }
            }

            DSText(
                text = product.price.priceToString(),
                type = TypographyType.Body1,
                maxLines = 2,
                modifier = Modifier
                    .padding(top = 5.dp)
                    .weight(2f)
                    .fillMaxWidth()
            )

            product.shipping?.let {
                if (it.freeShipping || it.storePickUp) {
                    DSText(
                        text = if (it.freeShipping) {
                            stringResource(R.string.product_card_free_shipping)
                        } else if (it.storePickUp) {
                            stringResource(R.string.product_card_pick_up_shipping)
                        } else "",
                        type = TypographyType.Caption2,
                        maxLines = 2,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .weight(2f)
                            .fillMaxWidth(),
                        color = SuccessColor
                    )
                }
            }
        }
        Divider(
            modifier = modifier.padding(top = dimensionResource(id = DesignSystemDimen.spacing_2)),
            thickness = dimensionResource(id = DesignSystemDimen.spacing_point_five),
            color = OnBackgroundColor
        )
    }
}

fun Double.priceToString(): String {
    return NumberFormat.getCurrencyInstance().format(this)
}

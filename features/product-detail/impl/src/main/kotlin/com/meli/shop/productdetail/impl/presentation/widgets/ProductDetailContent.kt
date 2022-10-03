package com.meli.shop.productdetail.impl.presentation.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.meli.shop.designsystem.atoms.DSPrimaryButton
import com.meli.shop.designsystem.atoms.DSText
import com.meli.shop.designsystem.atoms.TypographyType
import com.meli.shop.designsystem.utils.performHapticFeedback
import com.meli.shop.domains.productdetail.api.models.ProductDetailModel
import com.meli.shop.organism.ProductImage
import com.meli.shop.productdetail.impl.R
import java.text.NumberFormat

@Composable
fun ProductDetailContent(product: ProductDetailModel) {
    val context = LocalContext.current
    Column {
        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .weight(2f),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            item {
                DSText(
                    text = stringResource(
                        R.string.product_detail_conditions,
                        product.condition,
                        product.soldQuantity
                    ),
                    maxLines = 1,
                    type = TypographyType.Overline
                )
            }

            item {
                DSText(
                    text = product.title,
                    maxLines = 2,
                    type = TypographyType.Caption
                )
            }

            item {
                ProductImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(360.dp),
                    id = product.id,
                    images = product.pictures.map { it.url },
                    modeSlider = true
                )
            }


            item {
                Column {
                    if (product.originalPrice > 0) {
                        Text(
                            text = product.originalPrice.priceToString(),
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.7f),
                            textDecoration = TextDecoration.LineThrough
                        )
                    }

                    Text(
                        text = product.price.priceToString(),
                        modifier = Modifier.fillMaxWidth(),
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            }
        }

        DSPrimaryButton(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            text = stringResource(id = R.string.product_detail_buy_now),
            onClick = {
                context.performHapticFeedback()
            }
        )
    }
}

fun Double.priceToString(): String {
    return NumberFormat.getCurrencyInstance().format(this)
}

package com.meli.shop.organism

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.meli.shop.designsystem.utils.DesignSystemDimen

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProductImage(
    modifier: Modifier = Modifier,
    id: String,
    thumbnail: String? = null,
    images: List<String> = emptyList(),
    modeSlider: Boolean = false
) {

    if (modeSlider) {
        val pagerState = rememberPagerState()
        Column(
            modifier = Modifier
                .testTag("product_slider_container")
                .fillMaxWidth()
                .height(400.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
        ) {
            HorizontalPager(
                count = images.size,
                state = pagerState,
                modifier = Modifier
                    .weight(4f)
                    .testTag("product_slider_content")
            ) { page ->
                DSAsyncImage(
                    modifier = modifier.testTag("product_single_default_image"),
                    contentDescription = id,
                    size = dimensionResource(id = DesignSystemDimen.view_size_72),
                    shape = RoundedCornerShape(dimensionResource(id = DesignSystemDimen.radius_4)),
                    imageUrl = images[page],
                )
            }

            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
                    .align(Alignment.CenterHorizontally)
                    .testTag("product_slider_content_indicator"),
            )
        }
    } else {
        thumbnail?.let {
            DSAsyncImage(
                modifier = modifier.testTag("product_single_default_image"),
                contentDescription = id,
                size = dimensionResource(id = DesignSystemDimen.view_size_72),
                shape = RoundedCornerShape(dimensionResource(id = DesignSystemDimen.radius_4)),
                imageUrl = it
            )
        } ?: run {
            Image(
                imageVector = Icons.Default.Close,
                contentDescription = "",
                modifier = Modifier
            )
        }
    }
}

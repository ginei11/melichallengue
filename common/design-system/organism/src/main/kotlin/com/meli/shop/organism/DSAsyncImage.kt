package com.meli.shop.organism

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import com.meli.shop.designsystem.theme.BackgroundColor
import com.meli.shop.designsystem.utils.DesignSystemDrawable

@Composable
fun DSAsyncImage(
    imageUrl: String?,
    size: Dp,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = 0.dp
) {
    if (imageUrl.isValidImageUrl()) {
        SubcomposeAsyncImage(
            modifier = modifier
                .background(Color.White),
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = contentDescription,
            contentScale = ContentScale.Fit
        ) {
            when (painter.state) {
                is AsyncImagePainter.State.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp)
                    )
                }
                is AsyncImagePainter.State.Error -> {
                    ErrorBoxImage(
                        elevation = elevation,
                        contentDescription = contentDescription,
                        shape = shape,
                        modifier = modifier.size(size)
                    )
                }
                else -> {
                    SubcomposeAsyncImageContent()
                }
            }

        }
    } else {
        ErrorBoxImage(
            elevation = elevation,
            contentDescription = contentDescription,
            shape = shape,
            modifier = modifier.size(size)
        )
    }
}

@Composable
private fun ErrorBoxImage(
    @DrawableRes drawableResId: Int = DesignSystemDrawable.ic_not_image,
    elevation: Dp,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape
) {
    Surface(
        modifier = modifier,
        color = BackgroundColor,
        shape = shape,
        elevation = elevation
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp),
            painter = painterResource(id = drawableResId),
            contentDescription = contentDescription
        )
    }
}

private fun String?.isValidImageUrl() = isNullOrBlank().not() && this?.contains("http") == true

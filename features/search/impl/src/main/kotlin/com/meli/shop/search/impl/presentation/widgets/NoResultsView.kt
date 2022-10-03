package com.meli.shop.search.impl.presentation.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.meli.shop.designsystem.atoms.DSText
import com.meli.shop.designsystem.atoms.TypographyType
import com.meli.shop.designsystem.utils.DesignSystemDimen
import com.meli.shop.search.impl.R

@Composable
fun NoResultsView(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                end = dimensionResource(id = DesignSystemDimen.spacing_6),
                start = dimensionResource(id = DesignSystemDimen.spacing_6)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.searcherror))
        val progress by animateLottieCompositionAsState(
            composition = composition,
            iterations = LottieConstants.IterateForever
        )
        LottieAnimation(
            composition = composition,
            progress = { progress },
        )
        Spacer(
            modifier = Modifier.height(
                dimensionResource(id = DesignSystemDimen.spacing_4)
            )
        )
        DSText(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.search_no_results),
            type = TypographyType.H2,
            maxLines = 2,
            textAlign = TextAlign.Center
        )
    }
}

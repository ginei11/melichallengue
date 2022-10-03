package com.meli.shop.designsystem.atoms

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import com.meli.shop.designsystem.theme.DisabledBackgroundColor
import com.meli.shop.designsystem.theme.OnBackgroundColor
import com.meli.shop.designsystem.theme.OnPrimaryColor
import com.meli.shop.designsystem.theme.PrimaryButtonColor
import com.meli.shop.designsystem.theme.PrimaryColor
import com.meli.shop.designsystem.theme.SurfaceColor
import com.meli.shop.designsystem.utils.DesignSystemDimen
import com.meli.shop.designsystem.utils.performHapticFeedback

@Composable
fun DSPrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: @Composable () -> Unit = {},
    onClick: () -> Unit,
    enabled: Boolean = true,
) {
    FactoryButton(
        modifier = modifier,
        text = text,
        icon = icon,
        onClick = onClick,
        enabled = enabled,
        backgroundColor = PrimaryButtonColor,
        contentColor = OnPrimaryColor,
        textColor = SurfaceColor
    )
}

@Composable
private fun FactoryButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: @Composable () -> Unit = {},
    onClick: () -> Unit,
    enabled: Boolean = true,
    contentColor: Color,
    textColor: Color,
    backgroundColor: Color,
    elevation: ButtonElevation = ButtonDefaults.elevation(dimensionResource(DesignSystemDimen.spacing_zero))
) {
    val context = LocalContext.current
    Button(
        onClick = {
            context.performHapticFeedback()
            onClick.invoke()
        },
        enabled = enabled,
        modifier = modifier.height(dimensionResource(DesignSystemDimen.button_medium_height)),
        shape = RoundedCornerShape(dimensionResource(DesignSystemDimen.spacing_2)),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor,
            disabledBackgroundColor = DisabledBackgroundColor,
            disabledContentColor = OnBackgroundColor
        ),
        elevation = elevation
    ) {
        icon()
        DSText(text = text, type = TypographyType.Button, color = textColor)
    }
}


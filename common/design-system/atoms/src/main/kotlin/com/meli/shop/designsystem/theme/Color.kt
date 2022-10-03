package com.meli.shop.designsystem.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

private const val PRIMARY = 0xFFC8F2EF
private const val ON_PRIMARY = 0xFF373D43
private const val SECONDARY = 0xFFFFF3E5
private const val SECONDARY_VARIANT = 0xFFEDF4FD
private const val TERTIARY = 0xFF4793EF
private const val BACKGROUND = 0xFFF7F9FC
private const val ON_BACKGROUND = 0xFF777A7C
private const val DISABLED_BACKGROUND = 0xFFE1E9EF
private const val SURFACE = 0xFFFFFFFF
private const val ERROR = 0xFFEF233C
private const val SUCCESS = 0xFF4ADB95
private const val BLUE_MELI = 0xFF4793EF

val PrimaryColor = Color(PRIMARY)
val OnPrimaryColor = Color(ON_PRIMARY)
val PrimaryButtonColor = Color(BLUE_MELI)
val PrimaryVariantColor = Color(PRIMARY)
val SecondaryColor = Color(SECONDARY)
val OnSecondaryColor = Color(BACKGROUND)
val SecondaryVariantColor = Color(SECONDARY_VARIANT)
val OnTertiaryColor = Color(TERTIARY)
val BackgroundColor = Color(BACKGROUND)
val OnBackgroundColor = Color(ON_BACKGROUND)
val SurfaceColor = Color(SURFACE)
val ErrorColor = Color(ERROR)
val OnErrorColor = Color(SURFACE)
val SuccessColor = Color(SUCCESS)
val DisabledBackgroundColor = Color(DISABLED_BACKGROUND)

val DarkColorPalette = darkColors(
    primary = PrimaryColor,
    primaryVariant = PrimaryVariantColor,
    secondary = SecondaryColor
)

val LightColorPalette = lightColors(
    primary = PrimaryColor,
    primaryVariant = PrimaryVariantColor,
    secondary = SecondaryColor,
    secondaryVariant = SecondaryVariantColor,
    background = BackgroundColor,
    onBackground = OnBackgroundColor,
    surface = SurfaceColor,
    onSurface = SurfaceColor,
    error = ErrorColor,
    onError = OnErrorColor,
    onPrimary = OnPrimaryColor,
    onSecondary = OnSecondaryColor
)

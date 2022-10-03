package com.meli.shop.designsystem.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.meli.shop.designsystem.atoms.R

private val nunitoFont = FontFamily(
    Font(R.font.nunito_regular, FontWeight.Normal),
    Font(R.font.nunito_bold, FontWeight.Bold),
    Font(R.font.nunito_extra_bold, FontWeight.ExtraBold),
)

val Typography = Typography(
    h1 = getTextStyle(
        fontWeight = FontWeight.Black,
        fontSize = 40.sp,
        lineHeight = 56.sp
    ),
    h2 = getTextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 28.sp,
        lineHeight = 38.sp
    ),
    h3 = getTextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 38.sp,
    ),
    h4 = getTextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp,
        lineHeight = 34.sp,
    ),
    h5 = getTextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp,
        lineHeight = 28.sp,
    ),
    h6 = getTextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 16.sp,
        lineHeight = 22.sp,
    ),
    body1 = getTextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
    body2 = getTextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
    button = getTextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    caption = getTextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        lineHeight = 16.sp,
    ),
    overline = getTextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 10.sp,
        lineHeight = 14.sp,
    ),
)

fun getTextStyle(
    fontSize: TextUnit,
    fontWeight: FontWeight,
    lineHeight: TextUnit = 0.0.sp,
    letterSpacing: TextUnit = 0.0.sp,
): TextStyle {
    return TextStyle(
        fontWeight = fontWeight,
        fontSize = fontSize,
        fontFamily = nunitoFont,
        letterSpacing = letterSpacing,
        lineHeight = lineHeight
    )
}

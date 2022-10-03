package com.meli.shop.designsystem.atoms

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.meli.shop.designsystem.theme.MeliTheme
import com.meli.shop.designsystem.theme.OnPrimaryColor
import com.meli.shop.designsystem.theme.getTextStyle

@Composable
fun DSText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = OnPrimaryColor,
    type: TypographyType,
    textDecoration: TextDecoration = TextDecoration.None,
    fontWeight: FontWeight? = null,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null
) {
    DSText(
        text = AnnotatedString(text),
        color = color,
        modifier = modifier,
        type = type,
        maxLines = maxLines,
        textDecoration = textDecoration,
        fontWeight = fontWeight,
        textAlign = textAlign
    )
}

@Composable
fun DSText(
    modifier: Modifier = Modifier,
    text: AnnotatedString,
    color: Color = OnPrimaryColor,
    type: TypographyType,
    textDecoration: TextDecoration = TextDecoration.None,
    fontWeight: FontWeight? = null,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        color = color,
        modifier = modifier,
        style = getTypographyByType(type = type),
        textDecoration = textDecoration,
        fontWeight = fontWeight,
        maxLines = maxLines,
        textAlign = textAlign,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun getTypographyByType(type: TypographyType): TextStyle {
    return when (type) {
        TypographyType.H1 -> MaterialTheme.typography.h1
        TypographyType.H2 -> MaterialTheme.typography.h2
        TypographyType.H3 -> MaterialTheme.typography.h3
        TypographyType.H4 -> MaterialTheme.typography.h4
        TypographyType.H5 -> MaterialTheme.typography.h5
        TypographyType.H6 -> MaterialTheme.typography.h6
        TypographyType.H7 -> getTextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 22.sp,
        )
        TypographyType.Body1 -> MaterialTheme.typography.body1
        TypographyType.Body2 -> MaterialTheme.typography.body2
        TypographyType.Button -> MaterialTheme.typography.button
        TypographyType.Caption -> MaterialTheme.typography.caption
        TypographyType.Caption2 -> getTextStyle(
            fontWeight = FontWeight.ExtraBold,
            fontSize = 12.sp,
            lineHeight = 16.sp,
        )
        TypographyType.Overline -> getTextStyle(
            fontWeight = FontWeight.ExtraBold,
            fontSize = 10.sp,
            lineHeight = 14.sp
        )
        TypographyType.Overline2 -> getTextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 14.sp
        )
        TypographyType.Overline3 -> getTextStyle(
            fontWeight = FontWeight.ExtraBold,
            fontSize = 10.sp,
            lineHeight = 14.sp
        )
    }
}

enum class TypographyType {
    H1,
    H2,
    H3,
    H4,
    H5,
    H6,
    H7,
    Body1,
    Body2,
    Button,
    Caption,
    Caption2,
    Overline,
    Overline2,
    Overline3
}

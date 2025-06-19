package com.example.uilibrary.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.uilibrary.R

object AppTypography {
    private val font = FontFamily(Font(R.font.inter))

    val labelS: TextStyle = TextStyle(
        fontFamily = font,
        fontSize = 14.sp,
        fontWeight = FontWeight(550),
        lineHeight = 17.sp,
        letterSpacing = 0.16.sp
    )

    val labelM: TextStyle = TextStyle(
        fontFamily = font,
        fontSize = 16.sp,
        fontWeight = FontWeight(500),
        lineHeight = 22.sp,
        letterSpacing = 0.16.sp
    )
}


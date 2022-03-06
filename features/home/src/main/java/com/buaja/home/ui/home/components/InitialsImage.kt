package com.buaja.home.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.buaja.abstraction.extensions.getInitials


/**
 * @created 06/03/22 19.38
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Composable
fun InitialsImage(
    modifier: Modifier = Modifier,
    size: Dp = 40.dp,
    text: String,
    position: Int
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(
                colorList(position = position)
            )
            .size(size),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text.getInitials(),
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

fun colorList(position: Int): Color {
    val listColor = listOf(
        Color(0xFFB3DDC4),
        Color(0xFFF7EFDA),
        Color(0xFFF2D5EF),
        Color(0xFFCFC1E8),
        Color(0xFF9CA3D6)
    )

    val colorPosition = position % listColor.size

    return listColor[colorPosition]
}
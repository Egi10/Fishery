package com.buaja.home.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


/**
 * @created 06/03/22 20.18
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Composable
fun DividerVertical(
    color: Color = MaterialTheme.colors.onSurface.copy(alpha = 0.12f)
) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(1.dp)
            .background(color = color)
    )
}
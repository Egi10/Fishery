package com.buaja.ui_theme.extensions

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp


/**
 * @created 06/03/22 21.06
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Composable
fun RowScope.Space(width: Dp) {
    Spacer(modifier = Modifier.width(width))
}

@Composable
fun ColumnScope.Space(height: Dp) {
    Spacer(modifier = Modifier.height(height))
}


@Composable
fun LazyItemScope.Space(size: Dp) {
    Spacer(modifier = Modifier.size(size))
}
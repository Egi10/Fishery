package com.buaja.home.ui.home.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.buaja.home.R
import com.buaja.ui_theme.Purple500


/**
 * @created 06/03/22 20.44
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Composable
fun TextIcon(
    @DrawableRes drawable: Int,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    tint: Color = Purple500
) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .clickable(
                role = Role.Button,
            ) {
                onClick.invoke()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = drawable),
            contentDescription = null,
            tint = tint
        )

        Text(
            modifier = Modifier.padding(
                start = 6.dp
            ),
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Black
        )
    }
}

@Preview
@Composable
fun TextIconPreview() {
    TextIcon(
        drawable = R.drawable.ic_baseline_filter_alt_24,
        text = "Filter",
        onClick = {

        }
    )
}
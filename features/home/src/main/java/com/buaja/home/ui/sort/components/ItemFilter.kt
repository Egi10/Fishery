package com.buaja.home.ui.sort.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.buaja.home.R
import com.buaja.home.ui.sort.model.Filter
import com.buaja.ui_theme.Purple500
import com.buaja.ui_theme.extensions.Space


/**
 * @created 07/03/22 04.46
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Composable
fun ItemFilter(
    onClick: (Filter) -> Unit,
    filter: Filter
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick.invoke(filter)
            }
    ) {
        Text(
            modifier = Modifier
                .weight(1f),
            text = filter.text,
            fontSize = 14.sp
        )

        if (filter.status) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_check_24),
                contentDescription = null,
                tint = Purple500
            )
        }

        Space(width = 16.dp)
    }
}
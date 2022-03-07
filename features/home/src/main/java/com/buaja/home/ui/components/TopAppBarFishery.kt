package com.buaja.home.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.buaja.home.R
import com.buaja.ui_theme.Purple500


/**
 * @created 07/03/22 04.24
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Composable
fun TopAppBarFishery(
    onClick: () -> Unit,
    title: String,
    clear: String = "",
    onClickClear: () -> Unit = {},
) {
    TopAppBar(
        backgroundColor = Color.White,
        navigationIcon = {
            IconButton(
                onClick = onClick,
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_close_24),
                        contentDescription = null
                    )
                })
        },
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    color = Color.Black
                )

                if (clear.isNotEmpty()) {
                    Text(
                        modifier = Modifier
                            .clickable {
                                onClickClear.invoke()
                            }
                            .padding(
                                end = 24.dp
                            ),
                        text = clear,
                        fontSize = 14.sp,
                        color = Purple500
                    )
                }
            }
        }
    )
}
package com.buaja.home.ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.buaja.home.R


/**
 * @created 07/03/22 04.24
 * @author Julsapargi Nursam
 * @project Fishery
 **/
  
@Composable
fun TopAppBarFishery(
    onClick: () -> Unit,
    title: String
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
            Text(
                text = title,
                fontSize = 18.sp,
                color = Color.Black
            )
        }
    )
}
package com.buaja.home.ui.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.buaja.abstraction.extensions.formatRp
import com.buaja.abstraction.extensions.formatZero
import com.buaja.abstraction.extensions.removeSpaceFirst
import com.buaja.home.R
import com.buaja.home.domain.model.ListPrice


/**
 * @created 06/03/22 18.41
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Composable
fun ItemListPrice(
    item: ListPrice,
    position: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        InitialsImage(
            text = item.name,
            position = position
        )

        Column(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(
                    end = 16.dp,
                    start = 16.dp
                )
        ) {
            Text(
                text = "${item.areaCity.removeSpaceFirst()} - ${item.areaProvince}",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = item.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = stringResource(R.string.size, item.size.formatZero()),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal
            )
        }

        Text(
            text = item.price.formatRp(),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
        )
    }
}
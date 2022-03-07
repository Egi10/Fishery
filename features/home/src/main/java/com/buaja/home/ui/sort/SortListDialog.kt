package com.buaja.home.ui.sort

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.buaja.home.R
import com.buaja.home.ui.components.TopAppBarFishery
import com.buaja.home.ui.sort.components.ItemFilter
import com.buaja.home.ui.sort.model.Filter
import com.buaja.ui_theme.extensions.Space


/**
 * @created 07/03/22 03.23
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Composable
fun SortDialog(
    onDismissClick: () -> Unit,
    onSelectedClick: (Int) -> Unit,
    list: List<Filter>
) {
    Dialog(onDismissRequest = { }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.White
                )
        ) {
            TopAppBarFishery(
                onClick = onDismissClick,
                title = stringResource(id = R.string.sort)
            )

            Space(height = 16.dp)

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement
                    .spacedBy(16.dp),
                contentPadding = PaddingValues(
                    start = 16.dp
                ),
                content = {
                    itemsIndexed(list) { positions, item ->
                        ItemFilter(
                            filter = item,
                            onClick = {
                                onSelectedClick.invoke(positions)
                            }
                        )

                        Space(size = 16.dp)

                        Divider()
                    }
                }
            )
        }
    }
}
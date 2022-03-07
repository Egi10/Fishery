package com.buaja.home.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.buaja.home.ui.home.components.ItemListPrice
import com.buaja.home.ui.search.components.TopAppBarSearch
import com.buaja.ui_theme.extensions.Space


/**
 * @created 07/03/22 07.15
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Composable
fun SearchDialog(
    viewModel: SearchViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    onDismissClick: () -> Unit
) {
    val uiState = viewModel.uiState.collectAsState()

    Dialog(onDismissRequest = { }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.White
                )
        ) {
            TopAppBarSearch(
                onDismissClick = {
                    viewModel.clearSearch()
                    onDismissClick.invoke()
                },
                value = uiState.value.keyword,
                onValueChange = {
                    viewModel.setQuery(it)
                },
                onSearchClick = {
                    viewModel.getListByCommodity(it)
                }
            )

            Space(height = 8.dp)

            if (uiState.value.emptyData) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Data Tidak Ditemukan",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
            }

            LazyColumn(
                verticalArrangement = Arrangement
                    .spacedBy(16.dp),
                contentPadding = PaddingValues(
                    top = 8.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                ),
                content = {
                    itemsIndexed(uiState.value.list) { index, list ->
                        ItemListPrice(
                            item = list,
                            position = index
                        )

                        Divider(
                            modifier = Modifier
                                .padding(
                                    top = 16.dp
                                )
                        )
                    }
                }
            )
        }
    }
}
package com.buaja.home.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.buaja.home.domain.model.ListPrice
import com.buaja.home.ui.home.components.ItemListPrice
import com.buaja.home.R
import com.buaja.home.ui.home.components.DividerVertical
import com.buaja.home.ui.home.components.TextIcon
import com.buaja.ui_theme.extensions.Space


/**
 * @created 06/03/22 16.42
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Composable
fun HomeScreen(
    list: List<ListPrice>
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Fishery",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                },
                actions = {
                    IconButton(
                        onClick = { },
                        content = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_search_24),
                                contentDescription = null
                            )
                        }
                    )
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Space(height = 8.dp)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextIcon(
                        modifier = Modifier
                            .weight(1f),
                        drawable = R.drawable.ic_baseline_sort_24,
                        text = stringResource(R.string.sort),
                        onClick = { /*TODO*/ }
                    )

                    DividerVertical()

                    TextIcon(
                        modifier = Modifier
                            .weight(1f),
                        drawable = R.drawable.ic_outline_filter_alt_24,
                        text = stringResource(R.string.filter),
                        onClick = { /*TODO*/ }
                    )

                    DividerVertical()

                    TextIcon(
                        modifier = Modifier
                            .weight(1f),
                        drawable = R.drawable.ic_baseline_add_24,
                        text = stringResource(R.string.add),
                        onClick = { /*TODO*/ }
                    )
                }

                Space(height = 8.dp)

                Divider()

                Space(height = 8.dp)

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
                        itemsIndexed(list) { index, list ->
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
    )
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        list = listOf(
            ListPrice(
                name = "Ikan Tongkol",
                price = "10000",
                areaProvince = "Sumatera Barat",
                areaCity = "Padang",
                size = "60"
            ),
            ListPrice(
                name = "Ikan Nila",
                price = "5000",
                areaProvince = "Sumatera Barat",
                areaCity = "Padang",
                size = "10"
            )
        )
    )
}
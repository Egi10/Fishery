package com.buaja.home.ui.new_item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.buaja.home.R
import com.buaja.home.ui.components.TopAppBarFishery
import com.buaja.home.ui.new_item.components.FisheryOutlinedTextField


/**
 * @created 07/03/22 19.01
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Composable
fun NewItemDialog(
    viewModel: NewItemViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    onDismissClick: () -> Unit,
    onSuccess: () -> Unit
) {
    val uiState = viewModel.uiState.collectAsState()

    Dialog(onDismissRequest = {
        onDismissClick.invoke()
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.White
                )
        ) {
            TopAppBarFishery(
                onClick = {
                    onDismissClick.invoke()
                    viewModel.clear()
                },
                title = stringResource(id = R.string.add)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp
                ),
                content = {
                    item {
                        FisheryOutlinedTextField(
                            value = uiState.value.areaProvince,
                            onValueChange = {
                                viewModel.setAreaProvince(it)
                            },
                            label = stringResource(R.string.area_province)
                        )
                    }

                    item {
                        FisheryOutlinedTextField(
                            value = uiState.value.areaCity,
                            onValueChange = {
                                viewModel.setAreaCity(it)
                            },
                            label = stringResource(R.string.area_city)
                        )
                    }

                    item {
                        FisheryOutlinedTextField(
                            value = uiState.value.commodity,
                            onValueChange = {
                                viewModel.setCommodity(it)
                            },
                            label = stringResource(R.string.commodity)
                        )
                    }

                    item {
                        FisheryOutlinedTextField(
                            value = uiState.value.price,
                            onValueChange = {
                                viewModel.setPrice(it)
                            },
                            label = stringResource(R.string.price),
                            keyboardType = KeyboardType.Number
                        )
                    }

                    item {
                        FisheryOutlinedTextField(
                            value = uiState.value.size,
                            onValueChange = {
                                viewModel.setSize(it)
                            },
                            label = stringResource(id = R.string.size),
                            keyboardType = KeyboardType.Number
                        )
                    }

                    item {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth(),
                            onClick = {
                                viewModel.saveNewItem()
                            },
                            content = {
                                Text(text = stringResource(R.string.save))
                            }
                        )
                    }
                }
            )
        }
    }

    if (uiState.value.loading) {
        Dialog(
            onDismissRequest = {
                uiState.value.loading
            },
            DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
            ) {
                CircularProgressIndicator()
            }
        }
    }

    if (uiState.value.success) {
        onSuccess.invoke()
        viewModel.clear()
    }
}
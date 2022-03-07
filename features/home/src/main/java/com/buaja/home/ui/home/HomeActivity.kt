package com.buaja.home.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.buaja.home.R
import com.buaja.home.ui.sort.SortDialog
import com.buaja.home.ui.sort.model.Filter
import dagger.hilt.android.AndroidEntryPoint


/**
 * @created 06/03/22 16.11
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val uiState = viewModel.uiState.collectAsState()
            val filter = viewModel.listFilter.collectAsState()

            HomeScreen(
                list = uiState.value.list,
                loading = uiState.value.loading,
                onSortClick = {
                    viewModel.showSortDialog()
                }
            )

            if (uiState.value.showSortDialog) {
                SortDialog(
                    onDismissClick = {
                        viewModel.hideSortDialog()
                    },
                    list = filter.value,
                    onSelectedClick = { positions ->
                        viewModel.updateFilter(positions)
                        viewModel.getSelectedFilter()
                        viewModel.hideSortDialog()
                    }
                )
            }
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.getListPrice()

        setListFilter()
    }

    private fun setListFilter() {
        val listFilter: MutableList<Filter> = mutableListOf()
        val list = resources.getStringArray(R.array.sort_list)
        list.mapIndexed { index, s ->
            if (index == 0) {
                listFilter.add(
                    Filter(
                        text = s,
                        status = true
                    )
                )
            } else {
                listFilter.add(
                    Filter(
                        text = s,
                        status = false
                    )
                )
            }
        }

        viewModel.setFilter(
            list = listFilter
        )
    }
}
package com.buaja.home.ui.home

import android.os.Bundle
import android.view.KeyEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.buaja.home.R
import com.buaja.home.ui.filter.FilterDialog
import com.buaja.home.ui.new_item.NewItemDialog
import com.buaja.home.ui.search.SearchDialog
import com.buaja.home.ui.sort.SortDialog
import com.buaja.home.ui.sort.model.Sort
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
            val filter = viewModel.listSort.collectAsState()

            HomeScreen(
                list = uiState.value.list,
                loading = uiState.value.loading,
                onSortClick = {
                    viewModel.showSortDialog()
                },
                onSearchClick = {
                    viewModel.showSearchDialog()
                },
                onFilterClick = {
                    viewModel.showFilterDialog()
                },
                onNewItemClick = {
                    viewModel.showNewItemDialog()
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
                        viewModel.getSelectedSort()
                        viewModel.hideSortDialog()
                    }
                )
            }

            if (uiState.value.showSearchDialog) {
                SearchDialog(
                    onDismissClick = {
                        viewModel.hideSearchDialog()
                    }
                )
            }

            if (uiState.value.showFilterDialog) {
                FilterDialog(
                    onDismissClick = {
                        viewModel.hideFilterDialog()
                    },
                    onSelectedClick = {
                        viewModel.getSelectedFilter(areaProvince = it)
                        viewModel.hideFilterDialog()
                    },
                    onClearClick = {
                        viewModel.getAllList()
                        viewModel.hideFilterDialog()
                    }
                )
            }

            if (uiState.value.showNewItemDialog) {
                NewItemDialog(
                    onDismissClick = {
                        viewModel.hideNewItemDialog()
                    },
                    onSuccess = {
                        viewModel.getListPrice()
                        viewModel.hideNewItemDialog()
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
        val listSort: MutableList<Sort> = mutableListOf()
        val list = resources.getStringArray(R.array.sort_list)
        list.mapIndexed { index, s ->
            if (index == 0) {
                listSort.add(
                    Sort(
                        text = s,
                        status = true
                    )
                )
            } else {
                listSort.add(
                    Sort(
                        text = s,
                        status = false
                    )
                )
            }
        }

        viewModel.setFilter(
            list = listSort
        )
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
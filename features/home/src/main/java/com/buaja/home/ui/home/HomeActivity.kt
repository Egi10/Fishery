package com.buaja.home.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
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

            HomeScreen(
                list = uiState.value.list
            )
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.getListPrice()
    }
}
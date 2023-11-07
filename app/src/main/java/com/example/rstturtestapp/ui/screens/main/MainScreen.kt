package com.example.rstturtestapp.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreen(
    navController: NavHostController,
    viewModel: MainViewModel = getViewModel()
) {
    val data by viewModel.mainState.observeAsState()
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray)) {

        Text(text = data?.time ?: "error")

    }
}
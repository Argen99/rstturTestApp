package com.example.rstturtestapp.ui.navigation

import androidx.compose.ui.graphics.painter.Painter

data class BottomNavigationItem(
    val route: String,
    val title: String,
    val selectedIcon: Painter,
    val unselectedIcon: Painter
)
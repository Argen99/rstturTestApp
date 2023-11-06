package com.example.rstturtestapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rstturtestapp.ui.screens.ChatsScreen
import com.example.rstturtestapp.ui.screens.MapScreen
import com.example.rstturtestapp.ui.screens.MoreScreen
import com.example.rstturtestapp.ui.screens.ReserveScreen
import com.example.rstturtestapp.ui.screens.main.MainScreen

@Composable
fun NavGraph(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = NavigationDestinations.MAIN.name,
        modifier = modifier
    )
    {
        composable(route = NavigationDestinations.MAIN.name) {
            MainScreen(navHostController)
        }
        composable(route = NavigationDestinations.MAP.name) {
            MapScreen()
        }
        composable(route = NavigationDestinations.RESERVE.name) {
            ReserveScreen()
        }
        composable(route = NavigationDestinations.CHATS.name) {
            ChatsScreen()
        }
        composable(route = NavigationDestinations.MORE.name) {
            MoreScreen()
        }
    }
}
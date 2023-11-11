package com.example.rstturtestapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.rstturtestapp.ui.screens.ChatsScreen
import com.example.rstturtestapp.ui.screens.MapScreen
import com.example.rstturtestapp.ui.screens.MoreScreen
import com.example.rstturtestapp.ui.screens.ReserveScreen
import com.example.rstturtestapp.ui.screens.main.MainScreen
import com.example.rstturtestapp.ui.screens.main.MainViewModel
import com.example.rstturtestapp.ui.screens.main.blog_info.BlogScreen

@Composable
fun NavGraph(
    mainViewModel: MainViewModel,
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
            MainScreen(viewModel = mainViewModel) {
                navHostController.navigate("${NavigationDestinations.BLOG.name}/$it")
            }
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
        composable(
            route = "${NavigationDestinations.BLOG.name}/{blog_id}",
            arguments = listOf(
                navArgument("blog_id") {
                    type = NavType.IntType
                }
            )
        ) {
            val param = it.arguments?.getInt("blog_id") ?: 0
            BlogScreen(blogId = param) {
                navHostController.navigateUp()
            }
        }
    }
}
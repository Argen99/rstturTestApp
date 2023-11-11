package com.example.rstturtestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.rstturtestapp.ui.components.TopBar
import com.example.rstturtestapp.ui.navigation.BottomNavigationBar
import com.example.rstturtestapp.ui.navigation.NavGraph
import com.example.rstturtestapp.ui.navigation.NavigationDestinations
import com.example.rstturtestapp.ui.screens.main.MainViewModel
import com.example.rstturtestapp.ui.theme.RstturTestAppTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel = getViewModel()
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isLoading.value
            }
        }
        setContent {
            val topBarState = rememberSaveable { (mutableStateOf(true)) }
            RstturTestAppTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                when (navBackStackEntry?.destination?.route) {
                    NavigationDestinations.MAIN.name ->  topBarState.value = true
                    NavigationDestinations.MORE.name -> topBarState.value = true
                    NavigationDestinations.MAP.name -> topBarState.value = true
                    NavigationDestinations.CHATS.name -> topBarState.value = true
                    NavigationDestinations.RESERVE.name -> topBarState.value = true
                    else -> topBarState.value = false
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopBar(
                                navController,
                                topBarState
                            )
                        },
                        bottomBar = {
                            BottomNavigationBar(navController)
                        }
                    ) { paddingValues ->
                        NavGraph(
                            mainViewModel = viewModel,
                            navHostController = navController,
                            modifier = Modifier.padding(paddingValues)
                        )
                    }
                }
            }
        }
    }
}
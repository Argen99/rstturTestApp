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
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.rstturtestapp.ui.navigation.BottomNavigationBar
import com.example.rstturtestapp.ui.navigation.NavGraph
import com.example.rstturtestapp.ui.theme.RstturTestAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RstturTestAppTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(navController)
                        }
                    ) { paddingValues ->
                        NavGraph(
                            navHostController = navController,
                            Modifier.padding(paddingValues))
                    }
                }
            }
        }
    }
}
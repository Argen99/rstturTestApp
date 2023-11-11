package com.example.rstturtestapp.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.rstturtestapp.R
import com.example.rstturtestapp.ui.navigation.NavigationDestinations

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    navController: NavHostController,
    topBarState: MutableState<Boolean>
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val title: String = when (navBackStackEntry?.destination?.route ?: NavigationDestinations.MAIN.name) {
        NavigationDestinations.MAIN.name -> stringResource(id = R.string.main)
        NavigationDestinations.MAP.name -> stringResource(id = R.string.map)
        NavigationDestinations.MORE.name -> stringResource(id = R.string.more)
        NavigationDestinations.RESERVE.name -> stringResource(id = R.string.reserve)
        NavigationDestinations.CHATS.name -> stringResource(id = R.string.chats)
        else -> stringResource(id = R.string.main)
    }
    navBackStackEntry?.destination?.label.toString()
    AnimatedVisibility(
        visible = topBarState.value,
        enter = slideInVertically(initialOffsetY = { -it }),
        exit = slideOutVertically(targetOffsetY = { -it }),
        content = {
            TopAppBar(
                title = {
                    Text(
                        text = title,
                        style = TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontSize = 20.sp
                        )
                    )
                }
            )
        }
    )
}
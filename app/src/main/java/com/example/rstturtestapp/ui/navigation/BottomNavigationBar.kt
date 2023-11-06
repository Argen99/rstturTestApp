package com.example.rstturtestapp.ui.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.rstturtestapp.R
import com.example.rstturtestapp.ui.theme.Gray
import com.example.rstturtestapp.ui.theme.Primary
import com.example.rstturtestapp.ui.theme.White

@Composable
fun BottomNavigationBar(
    navHostController: NavHostController
) {
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    val items = listOf(
        BottomNavigationItem(
            route = NavigationDestinations.MAIN.name,
            title = stringResource(R.string.main),
            selectedIcon = painterResource(id = R.drawable.ic_selected_home),
            unselectedIcon = painterResource(id = R.drawable.ic_home)
        ),
        BottomNavigationItem(
            route = NavigationDestinations.MAP.name,
            title = stringResource(R.string.map),
            selectedIcon = painterResource(id = R.drawable.ic_selected_map),
            unselectedIcon = painterResource(id = R.drawable.ic_map)
        ),
        BottomNavigationItem(
            route = NavigationDestinations.RESERVE.name,
            title = stringResource(R.string.reserve),
            selectedIcon = painterResource(id = R.drawable.ic_selected_reserve),
            unselectedIcon = painterResource(id = R.drawable.ic_reserve)
        ),
        BottomNavigationItem(
            route = NavigationDestinations.CHATS.name,
            title = stringResource(R.string.chats),
            selectedIcon = painterResource(id = R.drawable.ic_selected_chats),
            unselectedIcon = painterResource(id = R.drawable.ic_chats)
        ),
        BottomNavigationItem(
            route = NavigationDestinations.MORE.name,
            title = stringResource(R.string.more),
            selectedIcon = painterResource(id = R.drawable.ic_selected_more),
            unselectedIcon = painterResource(id = R.drawable.ic_more)
        )
    )

    BottomNavigation(
        backgroundColor = White
    ) {
        items.forEachIndexed { index, item ->
            val bottomNavIcon = if (selectedItemIndex == index) {
                item.selectedIcon
            } else {
                item.unselectedIcon
            }
            BottomNavigationItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    navHostController.navigate(item.route)
                },
                icon = {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = bottomNavIcon,
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = item.title)
                },
                selectedContentColor = Primary,
                unselectedContentColor = Gray
            )
        }
    }
}
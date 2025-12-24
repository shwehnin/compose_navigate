package com.hninhninwai.xyz.mycomposeapp.navigations

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavBar(navController: NavController) {
    val navItems = listOf(
        NavigationItem.Category,
        NavigationItem.Order,
        NavigationItem.Cart
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val selectedItem = navItems.indexOfFirst { it.route == currentRoute }
    var selectedNavItem by rememberSaveable {
        mutableStateOf(if (selectedItem >= 0) selectedItem else 0)
    }
    NavigationBar {
        navItems.forEachIndexed { index, data ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    selectedNavItem = index
                    val route = if (data.route == NavigationRoute.Order.route) {
                        NavigationRoute.Order.route.plus("/30/true")
                    } else {
                        data.route
                    }

                    navController.navigate(route) {
                        navController.graph.startDestinationRoute?.let { path ->
                            popUpTo(path) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = { Icon(data.icon, contentDescription = data.title) },
                label = { Text(data.title) }
            )
        }
    }
}
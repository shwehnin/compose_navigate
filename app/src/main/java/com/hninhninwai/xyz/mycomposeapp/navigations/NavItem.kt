package com.hninhninwai.xyz.mycomposeapp.navigations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings

sealed class NavItem {
    object Home : Item(NavRoute.Home.path, "Home", Icons.Default.Home)
    object Profile : Item(NavRoute.Profile.path, "Profile", Icons.Default.Person)
    object Setting : Item(NavRoute.Setting.path, "Setting", Icons.Default.Settings)
}
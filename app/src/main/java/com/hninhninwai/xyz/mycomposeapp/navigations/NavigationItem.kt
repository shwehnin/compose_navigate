package com.hninhninwai.xyz.mycomposeapp.navigations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ShoppingCart

sealed class NavigationItem {
    object Category: NavigationData(route = NavigationRoute.Category.route, "Category", Icons.Default.Build)
    object Order: NavigationData(route = NavigationRoute.Order.route, "Order", Icons.Default.Info)
    object Cart: NavigationData(route = NavigationRoute.Cart.route, "Cart", Icons.Default.ShoppingCart)
}
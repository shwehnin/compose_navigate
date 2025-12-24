package com.hninhninwai.xyz.mycomposeapp.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hninhninwai.xyz.mycomposeapp.screens.CartScreen
import com.hninhninwai.xyz.mycomposeapp.screens.CategoryScreen
import com.hninhninwai.xyz.mycomposeapp.screens.OrderScreen

@Composable
fun Navigations(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationRoute.Category.route) {
        addCategoryScreen(navController = navController, this)
        addOrderScreen(navController = navController, this)
        addCartScreen(navController = navController, this)
    }
}

fun addCategoryScreen(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(route = NavigationRoute.Category.route) {
        CategoryScreen(navigateToOrder = { id, showProduct ->
            navController.navigate(NavigationRoute.Order.createRoute(30, true))
        }, navigateToCart = {
            navController.navigate(NavigationRoute.Cart.route)
        })
    }
}

fun addOrderScreen(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavigationRoute.Order.route.plus("/{id}/{showDetails}"),
        arguments = listOf(
            navArgument("id") {
                type = NavType.IntType
            },
            navArgument("showDetails") {
                type = NavType.BoolType
            }
        )) { navBackStackEntry ->
        val args = navBackStackEntry.arguments
        OrderScreen(
            id = args?.getInt("id")!!,
            showOrders = args.getBoolean("showDetails"),
            navigateToCart = {
                navController.navigate(NavigationRoute.Cart.route)
            },
        )
    }
}

fun addCartScreen(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(route = NavigationRoute.Cart.route) {
        CartScreen(navigateToCategory = {
            navController.navigate(NavigationRoute.Category.route)
        })
    }
}
package com.hninhninwai.xyz.mycomposeapp.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hninhninwai.xyz.mycomposeapp.screens.HomeScreen
import com.hninhninwai.xyz.mycomposeapp.screens.ProfileScreen
import com.hninhninwai.xyz.mycomposeapp.screens.SettingScreen
import kotlin.reflect.typeOf

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoute.Home.path) {
        addHomeScreen(navController, this)
        addProfileScreen(navController, this)
        addSettingScreen(navController, this)
    }
}

fun addHomeScreen(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(route = NavRoute.Home.path) {
        HomeScreen(navigateToProfile = { id, showDetails ->
            navController.navigate(
                NavRoute.Profile.path.plus("/$id/$showDetails")
            )
        }, navigateToSetting = { navController.navigate(NavRoute.Setting.path) })
    }
}

fun addProfileScreen(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Profile.path.plus("/{id}/{showDetails}"),
        arguments = listOf(navArgument(NavRoute.Profile.id) {
            type = NavType.IntType
        }, navArgument(NavRoute.Profile.showDetails) {
            type = NavType.BoolType
        })
    ) { navBackStackEntry ->
        val args = navBackStackEntry.arguments
        ProfileScreen(
            args?.getInt(NavRoute.Profile.id)!!,
            args.getBoolean(NavRoute.Profile.showDetails),
            navigateToSetting = { navController.navigate(NavRoute.Setting.path) })
    }
}

fun addSettingScreen(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(route = NavRoute.Setting.path) {
        SettingScreen(navigateToHome = { navController.navigate(NavRoute.Home.path) })
    }
}
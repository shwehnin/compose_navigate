package com.hninhninwai.xyz.mycomposeapp.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun BasicNavigate() {
    // 1 - NavController : Navigating between composables
    val navController = rememberNavController()

    // 2 - NavHost : Defines the nav graph, start & composable destinations
    NavHost(navController = navController, startDestination = "first") {
        composable("first") { FirstScreen(navController = navController) }
        composable(
            route = "second/{name}?age={age}", arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                },
                navArgument("age") {
                    type = NavType.StringType
                    defaultValue = "30"
                    nullable = true
                }
            )) { backStackEntry ->
            SecondScreen(
                navController = navController,
                backStackEntry.arguments?.getString("name").toString(),
                backStackEntry.arguments?.getString("age").toString()
            )
        }
    }
}
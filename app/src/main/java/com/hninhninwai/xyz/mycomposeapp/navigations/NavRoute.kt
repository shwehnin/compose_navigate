package com.hninhninwai.xyz.mycomposeapp.navigations

sealed class NavRoute(val path: String) {
    object Home : NavRoute("home")
    object Profile : NavRoute("profile") {
        val id = "id"
        val showDetails = "showDetails"
    }

    object Setting : NavRoute("setting")
}
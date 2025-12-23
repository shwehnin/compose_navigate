package com.hninhninwai.xyz.mycomposeapp.navigations

sealed class NavRoute(val path: String) {
    object Home : NavRoute("home")
    object Profile : NavRoute("profile") {
        fun createRoute(id: Int, showDetails : Boolean) : String{
            return "profile/$id/$showDetails"
        }
    }

    object Setting : NavRoute("setting")
}
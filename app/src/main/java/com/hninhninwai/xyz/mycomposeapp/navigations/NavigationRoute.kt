package com.hninhninwai.xyz.mycomposeapp.navigations

sealed class NavigationRoute(val route : String) {
    object Category : NavigationRoute("category")
    object Cart : NavigationRoute("cart")
    object Order: NavigationRoute("order") {
        fun createRoute(id : Int, showDetails : Boolean) : String{
            return "order/$id/$showDetails"
        }
    }
}
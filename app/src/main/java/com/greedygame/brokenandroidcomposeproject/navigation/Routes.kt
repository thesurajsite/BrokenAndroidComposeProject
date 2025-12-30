package com.greedygame.brokenandroidcomposeproject.navigation


sealed class Routes(val route: String) {
    data object NewsScreen: Routes("news")
    data object DetailScreen: Routes("detail")
}
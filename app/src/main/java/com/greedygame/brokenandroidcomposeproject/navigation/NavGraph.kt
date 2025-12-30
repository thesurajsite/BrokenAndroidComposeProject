package com.greedygame.brokenandroidcomposeproject.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.greedygame.brokenandroidcomposeproject.ui.NewsScreen
import androidx.navigation.compose.composable
import com.greedygame.brokenandroidcomposeproject.ui.DetailScreen
import com.greedygame.brokenandroidcomposeproject.viewmodel.MyViewModel

@Composable
fun NavGraph(navController: NavHostController){

    val viewModel: MyViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Routes.NewsScreen.route
    ) {
        composable(Routes.NewsScreen.route) {
            NewsScreen(navController, viewModel)
        }

        composable(Routes.DetailScreen.route) {
            val article by viewModel.selectedArticle.collectAsState()
            article?.let {
                DetailScreen(it)
            }
        }
    }
}
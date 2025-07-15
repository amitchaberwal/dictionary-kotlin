package com.amit.dictionaryapp.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.amit.dictionaryapp.presentation.home.view.HomeView


@Composable
fun AppNavigation(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(navController = navController, startDestination = AppRoute.Home.route) {
        composable(route = AppRoute.Home.route) {
            HomeView(navController = navController)
        }
    }
}
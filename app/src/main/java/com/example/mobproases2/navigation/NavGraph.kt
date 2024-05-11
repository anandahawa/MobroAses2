package com.example.mobproases2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mobproases2.ui.screen.AboutScreen
import com.example.mobproases2.ui.screen.DetailScreen
import com.example.mobproases2.ui.screen.KEY_ID_BUNGA
import com.example.mobproases2.ui.screen.MainScreen

@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            MainScreen(navController)
        }
        composable(route = Screen.FormBaru.route) {
            DetailScreen(navController)
        }
        composable(
            route = Screen.FormUbah.route,
            arguments = listOf(
                navArgument(KEY_ID_BUNGA) { type = NavType.LongType }
            )
        ) { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getLong(KEY_ID_BUNGA)
            DetailScreen(navController, id)
        }
        composable(route = Screen.About.route) {
            AboutScreen(navController)
        }
    }
}
package com.devspacecomposeinit.core

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devspacecomposeinit.presentation.ArtistScreen
import com.devspacecomposeinit.presentation.OnboardingScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.ONBOARDING
    ) {
        composable(Routes.ONBOARDING) {
            OnboardingScreen(navController)
        }
        composable(Routes.HOME) {
            ArtistScreen(navController)
        }
    }
}
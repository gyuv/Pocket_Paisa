package com.rork.pocketpaisa.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rork.pocketpaisa.ui.screens.MainScreen
import com.rork.pocketpaisa.ui.screens.OnboardingScreen
import com.rork.pocketpaisa.ui.screens.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen(navController = navController)
        }
        composable("onboarding") {
            OnboardingScreen(navController = navController)
        }
        composable("home") {
            MainScreen(rootNavController = navController)
        }
    }
}

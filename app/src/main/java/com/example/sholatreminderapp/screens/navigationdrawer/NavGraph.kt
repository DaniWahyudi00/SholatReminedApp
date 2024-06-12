package com.example.sholatreminderapp.screens.navigationdrawer

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sholatreminderapp.screens.aboutus.AboutUsScreen
import com.example.sholatreminderapp.screens.home.HomeScreen
import com.example.sholatreminderapp.screens.logout.LogoutScreen
import com.example.sholatreminderapp.screens.privacy.PrivacyScreen
import com.example.sholatreminderapp.screens.profile.ProfileScreen
import com.example.sholatreminderapp.screens.setting.SettingScreen

@Composable
fun SetUpNavGraph(
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(innerPadding = innerPadding)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(innerPadding = innerPadding)
        }
        composable(Screen.Privacy.route) {
            PrivacyScreen(innerPadding = innerPadding)
        }
        composable(Screen.AboutUs.route) {
            AboutUsScreen(innerPadding = innerPadding)
        }
        composable(Screen.Setting.route) {
            SettingScreen(innerPadding = innerPadding)
        }
        composable(Screen.Logout.route) {
            LogoutScreen(innerPadding = innerPadding)
        }
    }
}


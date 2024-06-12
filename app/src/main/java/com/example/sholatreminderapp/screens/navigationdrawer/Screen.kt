package com.example.sholatreminderapp.screens.navigationdrawer

sealed class Screen(var route: String) {

    object Home : Screen("home")
    object Profile : Screen("profile")
    object Privacy : Screen("notification")
    object AboutUs : Screen("about_us")
    object Setting : Screen("setting")
    object Logout : Screen("logout")

}
package com.example.sholatreminderapp.screens.navigationdrawer

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title : String,
    val route : String,
    val selectedIcon : ImageVector,
    val unselectedIcon : ImageVector,
)

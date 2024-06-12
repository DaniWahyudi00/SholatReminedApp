package com.example.sholatreminderapp.screens.navigationdrawer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.sholatreminderapp.Greeting
import com.example.sholatreminderapp.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawerItems(
    modifier: Modifier

){
    val navigationItems = listOf(
        NavigationItem(
            title = "Profile",
            route = Screen.Profile.route,
            selectedIcon = ImageVector.vectorResource(R.drawable.icon_user),
            unselectedIcon = ImageVector.vectorResource(R.drawable.icon_user_outline)
        ),
        NavigationItem(
            title = "Privacy Policy",
            route = Screen.Privacy.route,
            selectedIcon = ImageVector.vectorResource(R.drawable.icon_privacy),
            unselectedIcon = ImageVector.vectorResource(R.drawable.icon_privacy_outline)
        ),
        NavigationItem(
            title = "About Us",
            route = Screen.AboutUs.route,
            selectedIcon = ImageVector.vectorResource(R.drawable.icon_about_us),
            unselectedIcon = ImageVector.vectorResource(R.drawable.icon_about_us_outline)
        ),
        NavigationItem(
            title = "Setting",
            route = Screen.Setting.route,
            selectedIcon = ImageVector.vectorResource(R.drawable.icon_setting),
            unselectedIcon = ImageVector.vectorResource(R.drawable.icon_setting_outline)
        ),
        NavigationItem(
            title = "Logout",
            route = Screen.Logout.route,
            selectedIcon = ImageVector.vectorResource(R.drawable.icon_log_out),
            unselectedIcon = ImageVector.vectorResource(R.drawable.icon_log_out_outline)
        ),
    )

    Surface(modifier = Modifier
        .fillMaxSize()
        .clip(RoundedCornerShape(topEnd = 24.dp))
    ) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        var selectedItemIndex by rememberSaveable {
            mutableStateOf(0)
        }
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    Spacer(modifier = Modifier.height(16.dp))
                    navigationItems.forEachIndexed{index, item ->
                        NavigationDrawerItem(
                            label = {
                                Text(text = item.title)
                            },
                            selected = index == selectedItemIndex,
                            onClick = {
                                selectedItemIndex = index
                                scope.launch {
                                    drawerState.close()
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = if (index == selectedItemIndex){
                                        item.selectedIcon
                                    }else item.unselectedIcon,
                                    contentDescription = item.title
                                )
                            },
                            modifier = Modifier
                                .padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                    }
                }
            },
        ){
            Scaffold (
                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "Sholat Reminder App")
                        },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch { drawerState.open()
                                }
                            }){
                                Icon(
                                    imageVector = ImageVector.vectorResource(R.drawable.icon_menu),
                                    contentDescription = "Menu"
                                )
                            }
                        }
                    )
                }
            ) { innerPadding ->
                Greeting(
                    name = "Android",
                    modifier = Modifier.padding(innerPadding)
                )
            }
            }
        }
    }
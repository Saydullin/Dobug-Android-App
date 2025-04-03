package com.saydullin.dobugapp.navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.saydullin.dobugapp.component.user.Users
import com.saydullin.dobugapp.screen.HomeScreen

@Composable
fun BottomNavigation() {
    val navController = rememberNavController()
    val pages = listOf(
        NavigationItem("home", "Главная", Icons.Default.Home),
        NavigationItem("profile", "Профиль", Icons.Default.Email),
        NavigationItem("profiles", "Профиль", Icons.Default.Person),
        NavigationItem("settingss", "Настройки", Icons.Default.ShoppingCart),
        NavigationItem("settingsss", "Настройки", Icons.Default.Settings),
    )

    Scaffold(
        bottomBar = {
            NavigationBar(

                windowInsets = WindowInsets(left = 16.dp, right = 16.dp)
            ) {
                val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
                pages.forEach { item ->
                    NavigationBarItem(
                        icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                        selected = currentRoute == item.route,
                        onClick = {
                            if (currentRoute == item.route) return@NavigationBarItem
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    inclusive = false
                                }
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = "home", Modifier.padding(innerPadding)) {
            composable("home") { HomeScreen() }
            composable("profile") { Users() }
            composable("profiles") { Text("Настройки") }
            composable("settings") { Text("Настройки") }
            composable("settingss") { Text("Настройки") }
            composable("settingsss") { Text("Настройки") }
        }
    }
}

data class NavigationItem(val route: String, val label: String, val icon: ImageVector)



package com.saydullin.dobugapp.navigation

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.saydullin.dobugapp.screen.HomeScreen

@Composable
fun BottomNavigation() {
    val navController = rememberNavController()
    val pages = listOf(
        NavigationItem("home", "Главная", Icons.Default.Home),
        NavigationItem("profile", "Профиль", Icons.Default.Person),
        NavigationItem("settings", "Настройки", Icons.Default.Settings),
    )
    val context = LocalContext.current

    Scaffold(
        bottomBar = {
            NavigationBar {
                val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
                pages.forEach { item ->
                    NavigationBarItem(
                        icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                        label = { Text(item.label) },
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
            composable("profile") { Text("Профиль") }
            composable("settings") { Text("Настройки") }
        }
    }
}

data class NavigationItem(val route: String, val label: String, val icon: ImageVector)



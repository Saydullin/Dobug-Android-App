package com.saydullin.dobugapp.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.saydullin.dobugapp.component.user.Users
import com.saydullin.dobugapp.screen.auth.SignInScreen
import com.saydullin.dobugapp.screen.auth.SignUpScreen
import com.saydullin.dobugapp.screen.home.HomeScreen
import com.saydullin.dobugapp.screen.newPost.NewPostScreen
import com.saydullin.dobugapp.screen.profile.ProfileScreen
import com.saydullin.dobugapp.util.NavScreen

@Composable
fun BottomNavigation() {
    val navController = rememberNavController()
    val isNavigationBarEnable = remember { mutableStateOf(true) }

    val bottomScreens = listOf(
        NavScreen.Home,
        NavScreen.Chat,
        NavScreen.NewPost,
        NavScreen.Shop,
        NavScreen.Profile
    )

    val screens = bottomScreens.map {
        NavigationItem(it.route, it.title, it.icon)
    }

    val excludeScreens = listOf(
        NavScreen.SignUp.route,
        NavScreen.SignIn.route
    )

    Scaffold(
        bottomBar = {
            val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

            isNavigationBarEnable.value = !excludeScreens.contains(currentRoute)

            NavigationBar(
                modifier = Modifier
                    .alpha(if (isNavigationBarEnable.value) 1f else 0f)
                    .clickable(enabled = isNavigationBarEnable.value) {

                    },
                windowInsets = WindowInsets(left = 16.dp, right = 16.dp)
            ) {
                screens.forEach { item ->
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
        NavHost(
            navController = navController,
            startDestination = NavScreen.SignUp.route,
            Modifier.padding(innerPadding)
        ) {
            composable(NavScreen.Home.route) { HomeScreen() }
            composable(NavScreen.Chat.route) { Users() }
            composable(NavScreen.NewPost.route) { NewPostScreen() }
            composable(NavScreen.Shop.route) { Text("Магазин") }
            composable(NavScreen.Profile.route) { ProfileScreen() }

            composable(NavScreen.SignUp.route) { SignUpScreen(navController) }
            composable(NavScreen.SignIn.route) { SignInScreen(navController) }
        }
    }
}

data class NavigationItem(val route: String, val label: String, val icon: ImageVector)



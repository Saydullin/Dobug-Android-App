package com.saydullin.dobugapp.navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.saydullin.dobugapp.screen.auth.SignInScreen
import com.saydullin.dobugapp.screen.auth.SignUpScreen
import com.saydullin.dobugapp.screen.chat.ChatScreen
import com.saydullin.dobugapp.screen.home.HomeScreen
import com.saydullin.dobugapp.screen.newPost.NewPostScreen
import com.saydullin.dobugapp.screen.notification.NotificationScreen
import com.saydullin.dobugapp.screen.profile.ProfileScreen
import com.saydullin.dobugapp.screen.splash.SplashScreen
import com.saydullin.dobugapp.util.NavScreen
import com.saydullin.dobugapp.viewmodel.AuthViewModel
import com.saydullin.dobugapp.viewmodel.PostViewModel
import com.saydullin.dobugapp.viewmodel.SplashViewModel

@Composable
fun BottomNavigation() {
    val navController = rememberNavController()
    val postViewModel: PostViewModel = hiltViewModel()
    val authViewModel: AuthViewModel = hiltViewModel()
    val splashViewModel: SplashViewModel = hiltViewModel()
    val isNavigationBarEnable = remember { mutableStateOf(true) }

    val bottomScreens = listOf(
        NavScreen.Home,
        NavScreen.Chat,
        NavScreen.NewPost,
        NavScreen.Notifications,
        NavScreen.Profile
    )

    val screens = bottomScreens.map {
        NavigationItem(it.route, it.title, it.icon)
    }

    val excludeScreens = listOf(
        NavScreen.Splash.route,
        NavScreen.SignUp.route,
        NavScreen.SignIn.route,
    )

    Scaffold(
        bottomBar = {
            val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

            isNavigationBarEnable.value = !excludeScreens.contains(currentRoute)

            NavigationBar(
                modifier = Modifier
                    .alpha(if (isNavigationBarEnable.value) 1f else 0f),
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
            startDestination = NavScreen.Splash.route,
            Modifier.padding(innerPadding)
        ) {
            composable(NavScreen.Splash.route) {
                SplashScreen(
                    navController = navController,
                    splashViewModel = splashViewModel,
                )
            }
            composable(NavScreen.Home.route) {
                HomeScreen(
                    postViewModel = postViewModel,
                    navController = navController,
                )
            }
            composable(NavScreen.Chat.route) { ChatScreen() }
            composable(NavScreen.NewPost.route) { NewPostScreen() }
            composable(NavScreen.Notifications.route) { NotificationScreen() }
            composable(NavScreen.Profile.route) { ProfileScreen() }

            composable(NavScreen.SignUp.route) {
                SignUpScreen(
                    navController = navController,
                    authViewModel = authViewModel,
                )
            }
            composable(NavScreen.SignIn.route) {
                SignInScreen(
                    navController = navController,
                    authViewModel = authViewModel,
                )
            }
        }
    }
}

data class NavigationItem(val route: String, val label: String, val icon: ImageVector)



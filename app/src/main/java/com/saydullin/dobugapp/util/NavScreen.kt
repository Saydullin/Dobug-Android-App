package com.saydullin.dobugapp.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavScreen(
    val title: String,
    val route: String,
    val icon: ImageVector
) {

    data object Home: NavScreen(
        title = "Главная",
        route = "home",
        icon = Icons.Default.Home,
    )

    data object Chat: NavScreen(
        title = "Чат",
        route = "chat",
        icon = Icons.Default.Email,
    )

    data object NewPost: NavScreen(
        title = "Публикация",
        route = "publish",
        icon = Icons.Default.Add,
    )

    data object Notifications: NavScreen(
        title = "Уведомления",
        route = "notification",
        icon = Icons.Default.Notifications,
    )

    data object Profile: NavScreen(
        title = "Профиль",
        route = "profile",
        icon = Icons.Default.Person,
    )

    data object SignUp: NavScreen(
        title = "Регистрация",
        route = "signUp",
        icon = Icons.Default.Person
    )

    data object SignIn: NavScreen(
        title = "Авторизация",
        route = "signIn",
        icon = Icons.Default.Person
    )

    data object Splash: NavScreen(
        title = "Заставка",
        route = "splash",
        icon = Icons.Default.KeyboardArrowUp
    )

}
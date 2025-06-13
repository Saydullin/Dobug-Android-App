package com.saydullin.dobugapp.screen.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.saydullin.dobugapp.viewmodel.SplashViewModel

@Composable
fun SplashScreen(
    navController: NavController,
    splashViewModel: SplashViewModel,
) {

    val startDest by splashViewModel.startDestination.collectAsState()

    LaunchedEffect(startDest) {
        startDest?.let { navController.navigate(it) { popUpTo("splash") { inclusive = true } } }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

    }

}
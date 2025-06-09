package com.saydullin.dobugapp.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.saydullin.dobugapp.component.list.Posts
import com.saydullin.dobugapp.viewmodel.PostViewModel

@Composable
fun HomeScreen(
    postViewModel: PostViewModel
) {

    Box {
        Posts(postViewModel)
    }

}
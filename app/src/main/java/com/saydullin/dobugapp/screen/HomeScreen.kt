package com.saydullin.dobugapp.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.dobugapp.component.list.Posts

@Composable
fun HomeScreen() {

    Box(
        modifier = Modifier
            .padding(16.dp, 0.dp, 16.dp, 0.dp)
    ) {
        Posts()
    }
}
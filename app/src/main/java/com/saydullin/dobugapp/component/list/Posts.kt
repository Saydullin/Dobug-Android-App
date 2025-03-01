package com.saydullin.dobugapp.component.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.dobugapp.component.post.Post

@Composable
fun Posts(modifier: Modifier = Modifier) {

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Post()
        Post()
        Post()
        Post()
        Post()
        Post()
        Post()
        Post()
        Post()
        Post()
        Post()
        Post()
        Post()
        Post()
        Post()
        Post()
        Post()
    }
}
package com.saydullin.dobugapp.component.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.dobugapp.component.post.Post

@Composable
fun Posts() {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.outline),
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        items(12) {
            Post()
        }
    }

}
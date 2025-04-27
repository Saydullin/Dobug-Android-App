package com.saydullin.dobugapp.component.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.dobugapp.component.post.Post

@Composable
fun Posts(modifier: Modifier = Modifier) {

    val postList = listOf(
        "",
        "",
        "",
        "",
        "",
    )

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(postList) { index, item ->
            Post()
        }
    }
}
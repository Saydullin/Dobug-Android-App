package com.saydullin.dobugapp.component.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.dobugapp.component.post.Post
import com.saydullin.dobugapp.viewmodel.PostViewModel

@Composable
fun Posts(
    postViewModel: PostViewModel
) {
    val posts = postViewModel.posts.collectAsState()
    val postList = posts.value

    if (postList.isNullOrEmpty()) {
        Text(
            text = "Posts empty"
        )

        return
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.outline),
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        items(postList) {
            Post(it)
        }
    }

}
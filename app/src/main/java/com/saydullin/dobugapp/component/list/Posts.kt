package com.saydullin.dobugapp.component.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.saydullin.dobugapp.component.post.Post
import com.saydullin.dobugapp.viewmodel.PostViewModel

@Composable
fun Posts(
    postViewModel: PostViewModel
) {
    val posts = postViewModel.posts.collectAsLazyPagingItems()

    if (posts.itemCount == 0) {
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
        items(posts.itemCount) { index ->
            posts[index]?.let { Post(it) }
        }

        posts.apply {
            when {
                loadState.refresh is LoadState.Loading -> item { CircularProgressIndicator() }
                loadState.append is LoadState.Loading -> item { CircularProgressIndicator() }
                loadState.append is LoadState.Error -> item { Text("Load Error") }
            }
        }
    }

}
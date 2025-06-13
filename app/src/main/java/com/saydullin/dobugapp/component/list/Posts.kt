package com.saydullin.dobugapp.component.list

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.saydullin.dobugapp.component.post.Post
import com.saydullin.dobugapp.viewmodel.PostViewModel

@Composable
fun Posts(
    postViewModel: PostViewModel,
    navController: NavController,
) {
    val posts = postViewModel.posts.collectAsLazyPagingItems()
    val postsError = postViewModel.error.collectAsState()
    val context = LocalContext.current

//    if (postsError.value != null) {
//        Text(
//            text = "Что-то пошло не так"
//        )
//
//        Toast.makeText(context, "Авторизуйтесь", Toast.LENGTH_SHORT).show()
//
//        navController.navigate(NavScreen.SignIn.route)
//        return
//    }

    println("Постов получено ${posts.itemCount}")

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.outline),
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        items(posts.itemCount) { index ->
            val post = posts[index]
            if (post != null) {
                Post(post)
            } else {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color.Gray))
            }
        }

        posts.apply {
            when {
                loadState.refresh is LoadState.Loading -> item { CircularProgressIndicator() }
                loadState.append is LoadState.Loading -> item { CircularProgressIndicator() }
                loadState.append is LoadState.NotLoading  -> item { Text("Ну всё") }
                loadState.append is LoadState.Error -> item { Text("Load Error") }
            }
        }
    }

}
package com.saydullin.dobugapp.component.post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.saydullin.dobugapp.component.post.component.content.PostContent
import com.saydullin.dobugapp.component.post.component.gallery.PostGallery
import com.saydullin.dobugapp.component.post.component.header.PostHeader
import com.saydullin.dobugapp.component.post.component.reaction.PostReactionBar
import com.saydullin.dobugapp.component.post.component.tag.PostTag
import com.saydullin.domain.model.post.Post

@Composable
fun Post(
    post: Post
) {

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background),
    ) {
        Column {
            PostHeader(
                post = post
            )
            PostGallery()
            PostTag(
                title = "User Experience Testing"
            )
        }
        PostContent(
            post = post
        )
        PostReactionBar(
            post = post
        )
//        PostComment()
    }
}



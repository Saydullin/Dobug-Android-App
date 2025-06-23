package com.saydullin.dobugapp.component.post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.dobugapp.component.post.component.content.PostContent
import com.saydullin.dobugapp.component.post.component.gallery.PostGallery
import com.saydullin.dobugapp.component.post.component.header.PostHeader
import com.saydullin.dobugapp.component.post.component.reaction.PostReactionBar
import com.saydullin.dobugapp.component.post.component.tag.PostTag
import com.saydullin.domain.model.post.Post

@OptIn(ExperimentalLayoutApi::class)
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
            PostGallery(
                imagePreview = post.imagePreview
            )
            FlowRow(
                modifier = Modifier
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                for (tag in post.tags) {
                    PostTag(
                        title = tag.title
                    )
                }
            }
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



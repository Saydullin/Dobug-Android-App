package com.saydullin.dobugapp.component.post

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.dobugapp.component.post.component.comment.PostComment
import com.saydullin.dobugapp.component.post.component.content.PostContent
import com.saydullin.dobugapp.component.post.component.gallery.PostGallery
import com.saydullin.dobugapp.component.post.component.header.PostHeader
import com.saydullin.dobugapp.component.post.component.reaction.PostReactionBar
import com.saydullin.dobugapp.component.post.component.tag.PostTag

@Composable
fun Post(
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Column {
            PostHeader()
            PostGallery()
            PostTag(
                title = "User Experience Testing"
            )
        }
        PostContent()
        PostReactionBar()
//        PostComment()
    }
}



package com.saydullin.dobugapp.component.post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
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
fun Post() {

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background),
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



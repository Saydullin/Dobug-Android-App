package com.saydullin.dobugapp.component.post

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
fun Post(
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
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
            PostComment()
        }
    }
}



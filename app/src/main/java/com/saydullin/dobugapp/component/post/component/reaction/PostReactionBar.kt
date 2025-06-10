package com.saydullin.dobugapp.component.post.component.reaction

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.dobugapp.component.post.component.reaction.ui.PostReaction
import com.saydullin.dobugapp.util.formatNumbers
import com.saydullin.domain.model.post.Post

@Composable
fun PostReactionBar(
    modifier: Modifier = Modifier,
    post: Post
) {
    Row(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        PostReaction(
            modifier = Modifier.weight(1f),
            icon = Icons.Outlined.ThumbUp,
            title = formatNumbers(post.likes)
        )
        PostReaction(
            modifier = Modifier.weight(1f),
            icon = Icons.Outlined.Email,
            title = formatNumbers(post.comments)
        )
        PostReaction(
            modifier = Modifier.weight(1f),
            icon = Icons.Outlined.Refresh,
            title = formatNumbers(post.reposts),
        )
    }
}



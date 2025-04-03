package com.saydullin.dobugapp.component.post.component.comment.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun PostCommentPreviewContent(
    modifier: Modifier = Modifier,
) {

    Row(
        modifier = modifier,
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = "7 comments",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.bodyLarge
        )
    }

}
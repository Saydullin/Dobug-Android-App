package com.saydullin.dobugapp.component.post.component.comment.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PostCommentPreviewIcon(
    modifier: Modifier = Modifier,
) {

    Icon(
        modifier = modifier
            .size(20.dp),
        imageVector = Icons.Default.ArrowForward,
        contentDescription = "Open"
    )

}



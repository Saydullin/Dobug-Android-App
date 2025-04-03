package com.saydullin.dobugapp.component.post.component.reaction

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.dobugapp.component.post.component.reaction.ui.PostReaction

@Composable
fun PostReactionBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        PostReaction(
            modifier = Modifier.weight(1f),
            icon = Icons.Default.ThumbUp,
            title = "2.4K"
        )
        PostReaction(
            modifier = Modifier.weight(1f),
            icon = Icons.Default.Refresh,
            title = "455"
        )
        PostReaction(
            modifier = Modifier.weight(1f),
            icon = Icons.Default.Refresh,
            title = "2",
        )
    }
}



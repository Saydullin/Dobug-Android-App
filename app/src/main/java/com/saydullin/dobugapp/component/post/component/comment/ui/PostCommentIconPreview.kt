package com.saydullin.dobugapp.component.post.component.comment.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun PostCommentIconPreview(
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy((-10).dp)
    ) {
        for (i in 1..3) {
            Box(
                modifier = Modifier
                    .border(width = 1.dp, MaterialTheme.colorScheme.surface, shape = CircleShape)
                    .padding(1.dp)
            ) {
                AsyncImage(
                    model = "https://thispersondoesnotexist.com/",
                    contentDescription = "My image",
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                )
            }
        }
    }

}
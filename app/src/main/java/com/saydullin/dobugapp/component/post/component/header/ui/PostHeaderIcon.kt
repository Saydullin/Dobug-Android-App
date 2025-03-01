package com.saydullin.dobugapp.component.post.component.header.ui

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun PostHeaderIcon(
    modifier: Modifier = Modifier
) {

    AsyncImage(
        model = "https://thispersondoesnotexist.com/",
        contentDescription = "My image",
        modifier = modifier
            .size(50.dp)
            .clip(CircleShape)
    )

}



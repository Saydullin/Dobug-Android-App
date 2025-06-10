package com.saydullin.dobugapp.component.post.component.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.domain.model.post.Post

@Composable
fun PostContent(
    modifier: Modifier = Modifier,
    post: Post
) {

    Column(
        modifier = modifier
            .padding(horizontal = 16.dp),
    ) {
        Text(
            text = post.content,
            style = MaterialTheme.typography.bodyLarge,
        )
    }

}
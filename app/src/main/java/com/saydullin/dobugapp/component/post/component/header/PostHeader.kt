package com.saydullin.dobugapp.component.post.component.header

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.dobugapp.component.post.component.header.ui.PostHeaderContent
import com.saydullin.dobugapp.component.post.component.header.ui.PostHeaderIcon
import com.saydullin.domain.model.post.Post

@Composable
fun PostHeader(
    modifier: Modifier = Modifier,
    post: Post,
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        PostHeaderIcon(
            authorImageUrl = post.author.imagePath ?: "",
            authorImageAlt = "profile image"
        )
        PostHeaderContent(
            postAuthor = post.author
        )
    }

}



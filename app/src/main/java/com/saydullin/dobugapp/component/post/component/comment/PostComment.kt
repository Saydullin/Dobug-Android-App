package com.saydullin.dobugapp.component.post.component.comment

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.dobugapp.component.post.component.comment.ui.PostCommentIconPreview
import com.saydullin.dobugapp.component.post.component.comment.ui.PostCommentPreviewContent
import com.saydullin.dobugapp.component.post.component.comment.ui.PostCommentPreviewIcon

@Composable
fun PostComment(
    modifier: Modifier = Modifier
) {

    Card(
        modifier = Modifier
            .clickable {  },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        shape = Shapes().extraSmall,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp, 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            PostCommentIconPreview(
                modifier = Modifier.wrapContentWidth(Alignment.Start)
            )
            PostCommentPreviewContent(
                modifier = Modifier.weight(1f)
            )
            PostCommentPreviewIcon(
                modifier = Modifier.wrapContentWidth(Alignment.End)
            )
        }
    }

}
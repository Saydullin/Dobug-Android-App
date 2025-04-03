package com.saydullin.dobugapp.component.post.component.header

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.saydullin.dobugapp.component.post.component.header.ui.PostHeaderContent
import com.saydullin.dobugapp.component.post.component.header.ui.PostHeaderIcon
import com.saydullin.dobugapp.component.post.component.header.ui.PostHeaderMenu

@Composable
fun PostHeader(
    modifier: Modifier = Modifier,
) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        shape = Shapes().extraSmall,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp, 12.dp)
                .height(50.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PostHeaderIcon(
                modifier = Modifier.wrapContentWidth(Alignment.Start)
            )
            PostHeaderContent(
                modifier = Modifier.weight(1f)
            )
            PostHeaderMenu(
                modifier = Modifier.wrapContentWidth(Alignment.End)
            )
        }
    }

}



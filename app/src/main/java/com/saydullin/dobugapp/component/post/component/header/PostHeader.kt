package com.saydullin.dobugapp.component.post.component.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
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



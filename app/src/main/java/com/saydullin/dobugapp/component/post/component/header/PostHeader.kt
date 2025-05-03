package com.saydullin.dobugapp.component.post.component.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.dobugapp.component.post.component.header.ui.PostHeaderContent
import com.saydullin.dobugapp.component.post.component.header.ui.PostHeaderIcon

@Composable
fun PostHeader(
    modifier: Modifier = Modifier,
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        PostHeaderIcon()
        PostHeaderContent()
    }

}



package com.saydullin.dobugapp.component.tag

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AssistChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.core.app.NotificationCompat.Style

@Composable
fun Tag(
    title: String,
    style: TextStyle = MaterialTheme.typography.bodyLarge
) {

    Box {
        AssistChip(
            modifier = Modifier
                .height(24.dp),
            onClick = {},
            label = {
                Text(
                    style = style,
                    text = title,
                )
            }
        )
    }

}
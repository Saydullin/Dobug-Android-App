package com.saydullin.dobugapp.screen.notification.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.saydullin.dobugapp.model.notification.Notification

@Composable
fun NotificationItem(
    notification: Notification
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .clickable {  },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AsyncImage(
                model = notification.imageurl,
                contentDescription = notification.title,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = notification.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = notification.description,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Text(
                text = notification.time,
                style = MaterialTheme.typography.bodyLarge
            )
        }

    }

}
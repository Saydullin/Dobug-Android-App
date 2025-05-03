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

@Composable
fun NotificationItem() {

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
                model = "https://thispersondoesnotexist.com/",
                contentDescription = "My image",
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
                    text = "Надежда Антипенко",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Опубликовал(а) новый пост",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Text(
                text = "2 мин",
                style = MaterialTheme.typography.bodyLarge
            )
        }

    }

}
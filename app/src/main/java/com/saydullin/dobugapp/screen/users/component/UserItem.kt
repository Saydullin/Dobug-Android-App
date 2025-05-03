package com.saydullin.dobugapp.screen.users.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun UserItem() {

    Column {
        Row {
            AsyncImage(
                model = "https://thispersondoesnotexist.com/",
                contentDescription = "Profile",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
            Column {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Anastasia Rose Matonite",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Project Manager in Science Solutions",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }

}
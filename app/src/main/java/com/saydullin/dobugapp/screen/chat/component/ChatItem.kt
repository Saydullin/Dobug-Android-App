package com.saydullin.dobugapp.screen.chat.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.saydullin.dobugapp.component.tag.Tag

@Composable
fun ChatItem(

) {

    Box(
        modifier = Modifier
            .clickable {  }
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            AsyncImage(
                model = "https://thispersondoesnotexist.com/",
                contentDescription = "My image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
            Spacer(Modifier.width(16.dp))
            Column(
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Michael Johnson",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(Modifier.width(16.dp))
                    Tag(
                        title = "Project Manager",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
                Spacer(Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .weight(1f),
                        text = "Lorem Ipsum text for chat example or message example",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 4.dp),
                        text = "12:45",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}
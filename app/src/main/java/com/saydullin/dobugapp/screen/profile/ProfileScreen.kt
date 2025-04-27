package com.saydullin.dobugapp.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import com.saydullin.dobugapp.component.company.CompanyItem

@Composable
fun ProfileScreen() {

    val verticalScrollState = rememberScrollState()

    val achievements = listOf(
        "https://i.postimg.cc/65Q0cQNz/1yearAch.jpg",
        "https://i.postimg.cc/59gg8CD6/2yearAch.jpg",
        "https://i.postimg.cc/gjgKpC3v/3yearAch.jpg",
        "https://i.postimg.cc/LXBTCYXQ/4yearAch.jpg",
        "https://i.postimg.cc/D0vctv4v/5yearAch.jpg",
        "https://i.postimg.cc/MT85mbWj/6yearAch.jpg",
        "https://i.postimg.cc/GpDzDS1C/7yearAch.jpg",
        "https://i.postimg.cc/kgzfBPzs/8yearAch.jpg"
    )

    Column {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Сай",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(Modifier.weight(1f))
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "settings"
                )
            }
        }
        Column(
            modifier = Modifier
                .verticalScroll(verticalScrollState)
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
            ) {
                val shape = RoundedCornerShape(50.dp)

                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(shape)
                        .background(MaterialTheme.colorScheme.background)
                        .zIndex(1f)
                ) {
                    AsyncImage(
                        model = "https://thispersondoesnotexist.com/",
                        contentDescription = "My image",
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(2.dp)
                            .clip(shape)
                    )
                }
                LazyRow(
                    modifier = Modifier
                        .padding(start = 50.dp, top = 20.dp),
                    contentPadding = PaddingValues(start = 60.dp, end = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    items(achievements) { item ->
                        AsyncImage(
                            modifier = Modifier
                                .size(60.dp)
                                .clip(RoundedCornerShape(50.dp)),
                            model = item,
                            contentDescription = "My image",
                            contentScale = ContentScale.FillHeight,
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Android Developer",
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(16.dp))
                for (i in 0..53) {
                    CompanyItem()
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }

}
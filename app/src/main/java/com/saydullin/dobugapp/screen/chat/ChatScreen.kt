package com.saydullin.dobugapp.screen.chat

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.saydullin.dobugapp.R
import com.saydullin.dobugapp.screen.chat.component.ChatSearch
import com.saydullin.dobugapp.screen.notification.component.NotificationItem
import com.saydullin.dobugapp.util.NavScreen

@Composable
fun ChatScreen() {

//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//    ) {
//        ChatSearch()
//        LazyColumn(
//            modifier = Modifier
//                .fillMaxSize(),
//            contentPadding = PaddingValues(top = 30.dp)
//        ) {
////            items(19) {
////               ChatItem()
////            }
//        }
//    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(top = 50.dp),
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        item {
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                text = "Чаты",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(Color.Yellow),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                ChatSearch(
                    modifier = Modifier
                        .weight(1f)
                )
                IconButton(
                    onClick = {  }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "add"
                    )
                }
            }
            Spacer(Modifier.height(32.dp))
        }
        item {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "У вас пока нет ни одного чата",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }

}



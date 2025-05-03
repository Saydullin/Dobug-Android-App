package com.saydullin.dobugapp.screen.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.dobugapp.screen.chat.component.ChatItem
import com.saydullin.dobugapp.screen.chat.component.ChatSearch

@Composable
fun ChatScreen() {

    Column {
        ChatSearch()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(top = 30.dp)
        ) {
            items(19) {
               ChatItem()
            }
        }
    }

}
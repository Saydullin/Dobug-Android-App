package com.saydullin.dobugapp.screen.chat

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.saydullin.dobugapp.R
import com.saydullin.dobugapp.screen.chat.component.ChatSearch

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

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "У вас пока нет ни одного чата",
            style = MaterialTheme.typography.titleMedium
        )
    }

}



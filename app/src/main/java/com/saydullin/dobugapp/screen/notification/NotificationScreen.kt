package com.saydullin.dobugapp.screen.notification

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.saydullin.dobugapp.screen.notification.component.NotificationItem

@Composable
fun NotificationScreen() {

    LazyColumn(
    ) {
        items(12) {
            NotificationItem()
        }
    }

}
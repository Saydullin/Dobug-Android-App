package com.saydullin.dobugapp.screen.notification

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.saydullin.dobugapp.R

@Composable
fun NotificationScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.no_notifications),
            style = MaterialTheme.typography.titleMedium
        )
    }

//    LazyColumn(
//        modifier = Modifier
//            .fillMaxSize()
//    ) {
////        items(12) {
////            NotificationItem()
////        }
//    }

}
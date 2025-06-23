package com.saydullin.dobugapp.screen.notification

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.saydullin.dobugapp.R
import com.saydullin.dobugapp.model.notification.Notification
import com.saydullin.dobugapp.screen.notification.component.NotificationItem

@Composable
fun NotificationScreen() {

    val notifications = listOf(
        Notification(
            title = "Ваш аккаунт успешно прошел модерацию!",
            description = "Вы получили неограниченный доступ к функционалу!",
            imageurl = "https://play-lh.googleusercontent.com/xOcj2atXNcZPVf-BH9bKGpAzCsUVzcdE_D9bzSjO-HE5YckxiOma_FqxQ6YgXu8a7jHP=w240-h480-rw",
            time = "12:48"
        ),
        Notification(
            title = "Ваш аккаунт успешно прошел модерацию!",
            description = "Вы получили неограниченный доступ к функционалу!",
            imageurl = "https://play-lh.googleusercontent.com/xOcj2atXNcZPVf-BH9bKGpAzCsUVzcdE_D9bzSjO-HE5YckxiOma_FqxQ6YgXu8a7jHP=w240-h480-rw",
            time = "12:48"
        )
    )

//    Box(
//        modifier = Modifier
//            .fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(
//            text = stringResource(R.string.no_notifications),
//            style = MaterialTheme.typography.titleMedium
//        )
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
                text = "Уведомления",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(Modifier.height(32.dp))
        }
        items(notifications) { notification ->
            NotificationItem(notification)
        }
    }

}



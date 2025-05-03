package com.saydullin.dobugapp.screen.users

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.saydullin.dobugapp.screen.users.component.UserItem

@Composable
fun UsersScreen() {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(12) {
            UserItem()
        }
    }

}
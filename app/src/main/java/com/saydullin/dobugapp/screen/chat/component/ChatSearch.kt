package com.saydullin.dobugapp.screen.chat.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.dobugapp.component.search.Search

@Composable
fun ChatSearch() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Search(
            horizontalPadding = 16.dp
        )
    }

}
package com.saydullin.dobugapp.screen.newPost

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.unit.dp
import com.saydullin.dobugapp.util.NavScreen

@Composable
fun NewPostScreen(
    modifier: Modifier = Modifier
) {
    val isFocusedPostContent = remember { mutableStateOf(false) }
    val postContent = remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Новый пост",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(Modifier.height(32.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .onFocusChanged { focusState ->
                    isFocusedPostContent.value = focusState.isFocused
                },
            value = postContent.value,
            onValueChange = { postContent.value = it },
            label = {
                if (isFocusedPostContent.value) {
                    Text(
                        text = "Текст вашего поста",
                        style = MaterialTheme.typography.bodyLarge,
                    )
                } else {
                    Text(
                        text = "Поделитесь своими идеями",
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
            }
        )
        Spacer(Modifier.height(32.dp))
        Button(
            onClick = {  }
        ) {
            Text(
                text = "Опубликовать"
            )
        }
    }

}



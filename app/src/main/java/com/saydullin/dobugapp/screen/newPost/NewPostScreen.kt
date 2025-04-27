package com.saydullin.dobugapp.screen.newPost

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.unit.dp

@Composable
fun NewPostScreen(
    modifier: Modifier = Modifier
) {
    val isFocusedPostContent = remember { mutableStateOf(false) }
    val postContent = remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
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
                        text = "Post content",
                        color = MaterialTheme.colorScheme.outline,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                } else {
                    Text(
                        text = "Share with your ideas",
                        color = MaterialTheme.colorScheme.outline,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
            }
            ,
        )
    }

}
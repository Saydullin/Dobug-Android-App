package com.saydullin.dobugapp.screen.newPost

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.saydullin.dobugapp.R
import com.saydullin.dobugapp.util.NavScreen

@Composable
fun NewPostScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        selectedImageUri = uri
    }

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
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(5.dp, 5.dp))
                .background(MaterialTheme.colorScheme.surface)
                .clickable { launcher.launch("image/*") },
            contentAlignment = Alignment.Center
        ) {
            AnimatedContent(targetState = selectedImageUri != null) { targetCount ->
                if (targetCount) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize(),
                        painter = rememberAsyncImagePainter(selectedImageUri),
                        contentDescription = "Иконка добавление изображения",
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Image(
                        modifier = Modifier
                            .size(160.dp)
                            .padding(16.dp),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground),
                        painter = painterResource(id = R.drawable.add_image),
                        contentDescription = "Иконка добавление изображения",
                        contentScale = ContentScale.FillHeight
                    )
                }
            }
        }
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(MaterialTheme.colorScheme.background)
                .onFocusChanged { focusState ->
                    isFocusedPostContent.value = focusState.isFocused
                },

            value = postContent.value,
            onValueChange = { postContent.value = it },
            placeholder = {
                AnimatedContent(targetState = isFocusedPostContent.value) { targetCount ->
                    if (targetCount) {
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



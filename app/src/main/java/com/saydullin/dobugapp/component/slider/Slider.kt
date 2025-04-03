package com.saydullin.dobugapp.component.slider

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun Slider(
    modifier: Modifier = Modifier,
    imagesLinks: List<String>,
) {

    AsyncImage(
        modifier = modifier
            .fillMaxHeight(),
        model = imagesLinks[0],
        contentDescription = "My image",
        contentScale = ContentScale.FillHeight,
    )

}
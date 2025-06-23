package com.saydullin.dobugapp.component.post.component.gallery

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.dobugapp.component.slider.Slider
import com.saydullin.domain.model.image.ImagePreview

@Composable
fun PostGallery(
    imagePreview: ImagePreview
) {

    Slider(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        imagesLinks = listOf(imagePreview.imagePath ?: "")
    )
//    LazyRow(
//        modifier = Modifier
//            .padding(vertical = 12.dp),
//        contentPadding = PaddingValues(horizontal = 16.dp),
//        horizontalArrangement = Arrangement.spacedBy(12.dp)
//    ) {
//        items(6) {
//            AsyncImage(
//                model = "https://thispersondoesnotexist.com/",
//                contentDescription = "My image",
//                contentScale = ContentScale.FillWidth,
//                modifier = Modifier
//                    .height(200.dp)
//                    .clip(RoundedCornerShape(12.dp))
//            )
//        }
//    }

}
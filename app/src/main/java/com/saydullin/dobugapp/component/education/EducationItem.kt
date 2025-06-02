package com.saydullin.dobugapp.component.education

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.saydullin.dobugapp.model.education.EducationUI

@Composable
fun EducationItem(
    education: EducationUI
) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(MaterialTheme.colorScheme.background)
            .clickable {
                val url = education.url
                val intent = Intent(Intent.ACTION_VIEW)

                intent.data = Uri.parse(url)

                context.startActivity(intent)
            },
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    model = education.imageUrl,
                    contentDescription = education.companyTitle,
                    contentScale = ContentScale.FillHeight,
                )
                Text(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .weight(1f),
                    text = education.companyTitle,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = education.duration,
                    style = MaterialTheme.typography.titleSmall
                )
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = education.title,
                style = MaterialTheme.typography.titleMedium
            )
            Row {
                Text(
                    modifier = Modifier
                        .weight(1f),
                    text = education.description,
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }
    }

}
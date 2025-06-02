package com.saydullin.dobugapp.component.company

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.saydullin.dobugapp.model.company.CompanyUI

@Composable
fun CompanyItem(
    companyUI: CompanyUI
) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .clickable {
                val url = companyUI.companyUrl
                val intent = Intent(Intent.ACTION_VIEW)

                intent.data = Uri.parse(url)

                context.startActivity(intent)
            },
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(25.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    model = companyUI.imageUrl,
                    contentDescription = companyUI.title,
                    contentScale = ContentScale.FillHeight,
                )
                Text(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .weight(1f),
                    text = companyUI.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = companyUI.duration,
                    style = MaterialTheme.typography.titleSmall
                )
            }
            Spacer(Modifier.height(16.dp))
            Row {
                Text(
                    modifier = Modifier
                        .weight(1f),
                    text = companyUI.description,
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }
    }

}
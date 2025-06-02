package com.saydullin.dobugapp.component.offlinePlaceholder

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.saydullin.dobugapp.R

@Composable
fun OfflinePlaceholder(
    modifier: Modifier = Modifier,
    onUpdate: () -> Unit
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_no_connection),
            contentDescription = "No Internet",
            modifier = Modifier.size(50.dp),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium,
                text = "No internet connection"
            )
            Text(
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
                text = "Check internet connection and update again"
            )
        }
        Button(
            onClick = onUpdate
        ) {
            Text(
                text = "Update"
            )
        }
    }

}
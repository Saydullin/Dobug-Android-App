package com.saydullin.dobugapp.component.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ScreenHeader(
    leftIcon: ImageVector,
    title: String,
    rightIcon: ImageVector,
    onClickLeftIcon: () -> Unit,
    onClickRightIcon: () -> Unit,
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { onClickLeftIcon() }
        ) {
            Icon(
                imageVector = leftIcon,
                contentDescription = title
            )
        }
        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            text = title,
            style = MaterialTheme.typography.titleLarge
        )
        IconButton(
            onClick = { onClickRightIcon() }
        ) {
            Icon(
                imageVector = rightIcon,
                contentDescription = title
            )
        }
    }

}



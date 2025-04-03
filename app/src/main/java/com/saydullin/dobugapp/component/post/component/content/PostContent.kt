package com.saydullin.dobugapp.component.post.component.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PostContent(
    modifier: Modifier = Modifier
) {

    val content = "With 6 years of experience in project management, I've found that effective communication and collaboration are key to a successful team. One idea I have to improve our team's workflow is to implement regular, short stand-up meetings. These meetings would provide an opportunity for everyone to share their progress, discuss any obstacles, and align our goals for the day."

    Column(
        modifier = modifier
            .padding(horizontal = 16.dp),
    ) {
        Text(
            text = content,
            style = MaterialTheme.typography.bodyLarge,
        )
    }

}
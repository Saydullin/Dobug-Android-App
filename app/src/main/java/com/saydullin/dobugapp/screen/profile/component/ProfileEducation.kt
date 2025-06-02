package com.saydullin.dobugapp.screen.profile.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.dobugapp.component.education.EducationItem
import com.saydullin.dobugapp.model.education.EducationUI

@Composable
fun ProfileEducation(
    educationList: List<EducationUI>
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Education",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "2 years",
            style = MaterialTheme.typography.titleMedium
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
    for (education in educationList) {
        EducationItem(education)
        Spacer(modifier = Modifier.height(8.dp))
    }

}
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
import com.saydullin.dobugapp.component.company.CompanyItem
import com.saydullin.dobugapp.model.company.CompanyUI

@Composable
fun ProfileExperience(
    companies: List<CompanyUI>
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Опыт",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "9 лет",
            style = MaterialTheme.typography.titleMedium
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
    for (company in companies) {
        CompanyItem(company)
        Spacer(modifier = Modifier.height(8.dp))
    }

}
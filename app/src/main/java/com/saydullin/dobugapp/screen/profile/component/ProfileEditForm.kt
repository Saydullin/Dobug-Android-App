package com.saydullin.dobugapp.screen.profile.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.dobugapp.component.dropdown.Dropdown

@Composable
fun ProfileEditForm() {
    val usernameTextField = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = usernameTextField.value,
            onValueChange = { usernameTextField.value = it },
            label = {
                Text(
                    text = "Имя пользователя"
                )
            },
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = usernameTextField.value,
            onValueChange = { usernameTextField.value = it },
            label = {
                Text(
                    text = "Профессия"
                )
            },
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = usernameTextField.value,
            onValueChange = { usernameTextField.value = it },
            label = {
                Text(
                    text = "О себе"
                )
            },
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = usernameTextField.value,
            onValueChange = { usernameTextField.value = it },
            label = {
                Text(
                    text = "Опыт"
                )
            },
        )
        Dropdown()
    }

}
package com.saydullin.dobugapp.screen.profile.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileDescription() {

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Android разработчик",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Опытный Android-разработчик с коммерческим опытом и глубоким пониманием архитектурных подходов, включая MVVM и Clean Architecture. Уверенно работаю с Kotlin и Java, использую современные инструменты: Jetpack Compose, Coroutines, Room, Hilt.",
            style = MaterialTheme.typography.bodyLarge
        )
    }

}
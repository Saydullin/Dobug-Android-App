package com.saydullin.dobugapp.component.search

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(
    horizontalPadding: Dp = 0.dp
) {
    val searchText = remember { mutableStateOf("") }
    val searchActive = remember { mutableStateOf(false) }
    val paddingAnimation by animateDpAsState(
        targetValue = if (searchActive.value) 0.dp else horizontalPadding
    )

    Row {
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = paddingAnimation),
            windowInsets = WindowInsets(16.dp, 0.dp, 16.dp, 0.dp),
            query = searchText.value,
            onSearch = { searchText.value = it },
            onQueryChange = { searchText.value = it },
            active = searchActive.value,
            onActiveChange = { searchActive.value = it }
        ) { }
    }

}
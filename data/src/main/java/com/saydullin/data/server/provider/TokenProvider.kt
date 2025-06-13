package com.saydullin.data.server.provider

import com.saydullin.data.datastore.JwtSecurityDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class TokenProvider @Inject constructor(
    private val dataStore: JwtSecurityDataStore,
) {
    private val _token = MutableStateFlow<String?>(null)
    val token: StateFlow<String?> = _token

    init {
        CoroutineScope(Dispatchers.IO).launch {
            dataStore.getJwtKey()
                .collect {
                    _token.value = if (it.isNotBlank()) it else null
                }
        }
    }
}
package com.saydullin.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class JwtSecurityDataStore @Inject constructor(
    @ApplicationContext private val context: Context
): BaseDataStore(context, "jwt_security") {

    private val jwtKey = stringPreferencesKey("jwt_key")

    fun getJwtKey(): Flow<String> = getValue(jwtKey, "")

    suspend fun setJwtKey(key: String) {
        setValue(jwtKey, "")
    }

}



package com.saydullin.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

abstract class BaseDataStore(context: Context, storeName: String) {

    private val Context.dataStore by preferencesDataStore(name = storeName)
    private val dataStore = context.dataStore

    protected fun <T> getValue(key: Preferences.Key<T>, defaultValue: T): Flow<T> {
        return dataStore.data
            .map { preferences ->
                preferences[key] ?: defaultValue
            }
    }

    protected suspend fun <T> setValue(key: Preferences.Key<T>, value: T) {
        dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    protected suspend fun <T> removeValue(key: Preferences.Key<T>) {
        dataStore.edit { preferences ->
            preferences.remove(key)
        }
    }

    protected suspend fun clear() {
        dataStore.edit { it.clear() }
    }
}

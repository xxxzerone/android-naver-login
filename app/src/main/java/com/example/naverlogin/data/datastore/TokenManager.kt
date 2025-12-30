package com.example.naverlogin.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TokenManager(private val context: Context) {
    private val Context.dataStore by preferencesDataStore(name = AUTH_PREFS)
    private val ACCESS_TOKEN = stringPreferencesKey(Companion.ACCESS_TOKEN)

    val accessToken: Flow<String?> = context.dataStore.data.map { it[ACCESS_TOKEN] }

    suspend fun saveToken(token: String) {
        context.dataStore.edit { it[ACCESS_TOKEN] = token }
    }

    suspend fun clearToken() {
        context.dataStore.edit { it.remove(ACCESS_TOKEN) }
    }

    companion object {
        const val AUTH_PREFS = "auth_prefs"
        const val ACCESS_TOKEN = "access_token"
    }
}

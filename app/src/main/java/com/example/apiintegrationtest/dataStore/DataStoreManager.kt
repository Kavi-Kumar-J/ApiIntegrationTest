package com.example.apiintegrationtest.dataStore

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("UserData")

class DataStoreManager @Inject constructor(application: Application) {

    private val userDataStore = application.dataStore

    private val tokenKey = stringPreferencesKey("token")

    val token: Flow<String> = userDataStore.data.map {
        it[tokenKey] ?: ""
    }

    suspend fun saveToken(token: String) {
        userDataStore.edit {
            it[tokenKey] = token
        }
    }

}
package com.telegramflow.example.data.local

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TelegramConfigStorage @Inject constructor(
    @ApplicationContext context: Context
) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("telegram_config", Context.MODE_PRIVATE)

    var appId: Int
        get() = prefs.getInt(KEY_APP_ID, 0)
        set(value) = prefs.edit().putInt(KEY_APP_ID, value).apply()

    var appHash: String?
        get() = prefs.getString(KEY_APP_HASH, null)
        set(value) = prefs.edit().putString(KEY_APP_HASH, value).apply()

    val isConfigured: Boolean
        get() = appId != 0 && !appHash.isNullOrBlank()

    companion object {
        private const val KEY_APP_ID = "app_id"
        private const val KEY_APP_HASH = "app_hash"
    }
}

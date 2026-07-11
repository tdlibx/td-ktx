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

  /**
   * When true, TDLib connects to Telegram's test environment (test DC) instead of production.
   * See https://core.telegram.org/tdlib/docs/classtd_1_1td__api_1_1set_tdlib_parameters.html
   */
    var useTestDc: Boolean
        get() = prefs.getBoolean(KEY_USE_TEST_DC, false)
        set(value) = prefs.edit().putBoolean(KEY_USE_TEST_DC, value).apply()

    val isConfigured: Boolean
        get() = appId != 0 && !appHash.isNullOrBlank()

    fun clear() {
        prefs.edit().clear().apply()
    }

    companion object {
        private const val KEY_APP_ID = "app_id"
        private const val KEY_APP_HASH = "app_hash"
        private const val KEY_USE_TEST_DC = "use_test_dc"
    }
}

package com.telegramflow.example.data.local

import platform.Foundation.NSUserDefaults
import platform.Foundation.NSFileManager
import platform.Foundation.NSSearchPathForDirectoriesInDomains
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSUserDomainMask

class IosTelegramConfigStorage : TelegramConfigStorage {
    private val defaults = NSUserDefaults.standardUserDefaults

    override var appId: Int
        get() = defaults.integerForKey(KEY_APP_ID).toInt()
        set(value) = defaults.setInteger(value.toLong(), KEY_APP_ID)

    override var appHash: String?
        get() = defaults.stringForKey(KEY_APP_HASH)
        set(value) = defaults.setObject(value, KEY_APP_HASH)

    override var useTestDc: Boolean
        get() = defaults.boolForKey(KEY_USE_TEST_DC)
        set(value) = defaults.setBool(value, KEY_USE_TEST_DC)

    override val isConfigured: Boolean
        get() = appId != 0 && !appHash.isNullOrBlank()

    override val filesDir: String
        get() {
            val paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, true)
            return paths.first() as String
        }

    override fun clear() {
        defaults.removeObjectForKey(KEY_APP_ID)
        defaults.removeObjectForKey(KEY_APP_HASH)
        defaults.removeObjectForKey(KEY_USE_TEST_DC)
    }

    companion object {
        private const val KEY_APP_ID = "app_id"
        private const val KEY_APP_HASH = "app_hash"
        private const val KEY_USE_TEST_DC = "use_test_dc"
    }
}

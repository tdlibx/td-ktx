package com.telegramflow.example

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.telegramflow.example.data.local.TelegramConfigStorage

object TestFixtures {
    fun targetContext(): Context = InstrumentationRegistry.getInstrumentation().targetContext

    fun clearTelegramConfig() {
        TelegramConfigStorage(targetContext()).clear()
    }

    fun telegramAppId(): Int? =
        InstrumentationRegistry.getArguments().getString("telegram_app_id")?.toIntOrNull()

    fun telegramAppHash(): String? =
        InstrumentationRegistry.getArguments().getString("telegram_app_hash")
}

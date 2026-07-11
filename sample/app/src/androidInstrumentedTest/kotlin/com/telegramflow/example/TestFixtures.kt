package com.telegramflow.example

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.telegramflow.example.data.local.AndroidTelegramConfigStorage

object TestFixtures {
    fun targetContext(): Context = InstrumentationRegistry.getInstrumentation().targetContext

    fun clearTelegramConfig() {
        AndroidTelegramConfigStorage(targetContext()).clear()
    }


    fun telegramAppId(): Int? =
        InstrumentationRegistry.getArguments().getString("telegram_app_id")?.toIntOrNull()

    fun telegramAppHash(): String? =
        InstrumentationRegistry.getArguments().getString("telegram_app_hash")
}

package com.telegramflow.example

import com.telegramflow.example.data.local.IosTelegramConfigStorage
import com.telegramflow.example.data.repo.TelegramRepository
import kotlinx.telegram.core.TelegramFlow

/**
 * Factory exposed to Swift. Creates TelegramFlow internally so Swift
 * doesn't need to import the libtd-ktx framework dependency directly.
 */
fun createRepository(config: IosTelegramConfigStorage): TelegramRepository {
    val api = TelegramFlow()
    return TelegramRepository(api, config)
}

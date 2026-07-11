package com.telegramflow.example.data.repo

import androidx.compose.runtime.staticCompositionLocalOf

val LocalTelegramRepository = staticCompositionLocalOf<TelegramRepository> {
    error("No TelegramRepository provided")
}

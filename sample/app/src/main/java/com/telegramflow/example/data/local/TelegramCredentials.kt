package com.telegramflow.example.data.local

import com.telegramflow.example.BuildConfig
import org.drinkless.td.libcore.telegram.TdApi


object TelegramCredentials {
    val parameters = TdApi.TdlibParameters().apply {
        databaseDirectory = "/data/user/0/${BuildConfig.APPLICATION_ID}/files/td"
        useMessageDatabase = false
        useSecretChats = false
        useFileDatabase = true
        systemLanguageCode = "en"
        deviceModel = "Android"
        systemVersion = "Example"
        applicationVersion = "1.0"
        apiId = BuildConfig.TELEGRAM_APP_ID
        apiHash = BuildConfig.TELEGRAM_APP_HASH
        enableStorageOptimizer = true
    }
}
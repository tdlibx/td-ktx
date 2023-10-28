package com.telegramflow.example.data.local

import org.drinkless.td.libcore.telegram.TdApi


//Replace with your personal telegram credentials
object TelegramCredentials {
    val parameters = TdApi.TdlibParameters().apply {
        databaseDirectory = "/data/user/0/com.telegramflow.example/files/td"
        useMessageDatabase = false
        useSecretChats = false
        useFileDatabase = true
        systemLanguageCode = "en"
        deviceModel = "Android"
        systemVersion = "Example"
        applicationVersion = "1.0"
        enableStorageOptimizer = true
    }
}
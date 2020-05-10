package com.github.tdlibx.example

import org.drinkless.td.libcore.telegram.TdApi


//Replace with your personal telegram credentials
object TelegramCredentials {
    val parameters = TdApi.TdlibParameters().apply {
        databaseDirectory = "/data/user/0/com.github.tdlib.flow.example/files/td"
        useMessageDatabase = false
        useSecretChats = false
        apiId = 0
        apiHash = "your hash code"
        useFileDatabase = true
        systemLanguageCode = "en"
        deviceModel = "Android"
        systemVersion = "Example"
        applicationVersion = "1.0"
        enableStorageOptimizer = true
    }
}
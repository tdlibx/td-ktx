package com.telegramflow.example.data.local

interface TelegramConfigStorage {
    var appId: Int
    var appHash: String?
    var useTestDc: Boolean
    val isConfigured: Boolean
    val filesDir: String
    
    fun clear()
}

package com.telegramflow.example.ui.screen.config

import androidx.lifecycle.ViewModel
import com.telegramflow.example.data.local.TelegramConfigStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ConfigViewModel @Inject constructor(
    private val configStorage: TelegramConfigStorage
) : ViewModel() {

    fun saveConfig(appId: Int, appHash: String, useTestDc: Boolean) {
        configStorage.appId = appId
        configStorage.appHash = appHash
        configStorage.useTestDc = useTestDc
    }
}

package com.telegramflow.example

import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import com.telegramflow.example.data.local.MacosTelegramConfigStorage
import com.telegramflow.example.data.repo.LocalTelegramRepository
import com.telegramflow.example.data.repo.TelegramRepository
import com.telegramflow.example.data.local.AuthState
import com.telegramflow.example.ui.screen.config.ConfigScreen
import com.telegramflow.example.ui.screen.enterPhone.LoginScreen
import com.telegramflow.example.ui.screen.MainScreen
import com.telegramflow.example.ui.theme.TelegramFlowComposeTheme
import kotlinx.coroutines.launch
import kotlinx.telegram.core.TelegramFlow
import platform.AppKit.NSApplication
import platform.AppKit.NSApp
import platform.AppKit.NSApplicationActivationPolicy
import platform.Foundation.NSProcessInfo

fun main() {
    val app = NSApplication.sharedApplication()

    // Without this the process runs as a background "accessory" — the window
    // appears but can't receive keyboard/mouse focus, making text fields
    // unresponsive. NSApplicationActivationPolicyRegular (0) promotes the
    // process to a regular foreground app that can receive key events.
    @Suppress("UNCHECKED_CAST")
    app.setActivationPolicy(NSApplicationActivationPolicy.NSApplicationActivationPolicyRegular)
    app.activateIgnoringOtherApps(true)

    val configStorage = MacosTelegramConfigStorage()
    
    // Pre-fill from env vars if available
    if (!configStorage.isConfigured) {
        val env = NSProcessInfo.processInfo().environment
        val appIdStr = env["TELEGRAM_APP_ID"] as? String
        val appHash = env["TELEGRAM_APP_HASH"] as? String
        if (appIdStr != null && appHash != null) {
            appIdStr.toIntOrNull()?.let { appId ->
                configStorage.appId = appId
                configStorage.appHash = appHash
            }
        }
    }

    val telegramRepository = run {
        val api = TelegramFlow()
        TelegramRepository(api, configStorage)
    }

    Window(title = "TelegramFlow - macOS") {
        var phoneNumber by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var code by remember { mutableStateOf("") }
        var isConfigured by remember { mutableStateOf(configStorage.isConfigured) }
        val authState by telegramRepository.authFlow.collectAsState(null)
        val scope = rememberCoroutineScope()

        TelegramFlowComposeTheme {
            CompositionLocalProvider(
                LocalTelegramRepository provides telegramRepository
            ) {
                if (!isConfigured) {
                    ConfigScreen(
                        configStorage = configStorage,
                        onConfigSaved = {
                            isConfigured = true
                            scope.launch {
                                telegramRepository.tryAndSetParams()
                            }
                        }
                    )
                } else if (authState is AuthState.LoggedIn) {
                    MainScreen()
                } else {
                    LoginScreen(
                        phoneNumber = phoneNumber,
                        password = password,
                        code = code,
                        onPhoneNumberChanged = { phoneNumber = it },
                        onCodeChanged = { code = it },
                        onPasswordChanged = { password = it },
                        onNextClicked = {}
                    )
                }
            }
        }
    }

    app.run()
}

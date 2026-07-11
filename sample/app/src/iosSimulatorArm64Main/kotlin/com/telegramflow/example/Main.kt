package com.telegramflow.example

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import com.telegramflow.example.ui.screen.enterPhone.LoginScreen
import com.telegramflow.example.ui.screen.config.ConfigScreen
import com.telegramflow.example.ui.screen.MainScreen
import com.telegramflow.example.ui.theme.TelegramFlowComposeTheme
import androidx.compose.runtime.CompositionLocalProvider
import com.telegramflow.example.data.repo.LocalTelegramRepository
import com.telegramflow.example.data.repo.TelegramRepository
import com.telegramflow.example.data.local.AuthState
import com.telegramflow.example.data.local.TelegramConfigStorage
import androidx.compose.runtime.*
import kotlinx.coroutines.launch

fun MainViewController(
    telegramRepository: TelegramRepository,
    configStorage: TelegramConfigStorage
): UIViewController = ComposeUIViewController {
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

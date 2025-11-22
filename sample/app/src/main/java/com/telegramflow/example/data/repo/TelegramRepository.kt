package com.telegramflow.example.data.repo

import com.telegramflow.example.BuildConfig
import com.telegramflow.example.data.local.AuthState
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.telegram.core.TelegramFlow
import kotlinx.telegram.coroutines.checkAuthenticationCode
import kotlinx.telegram.coroutines.checkAuthenticationPassword
import kotlinx.telegram.coroutines.getUser
import kotlinx.telegram.coroutines.setAuthenticationPhoneNumber
import kotlinx.telegram.coroutines.setTdlibParameters
import kotlinx.telegram.extensions.UserKtx
import kotlinx.telegram.flows.authorizationStateFlow
import kotlinx.telegram.flows.userStatusFlow
import org.drinkless.tdlib.TdApi

@Singleton
class TelegramRepository @Inject constructor(override val api: TelegramFlow) : UserKtx {

    val authFlow: Flow<AuthState?> = api.authorizationStateFlow()
        .onEach { authorizationState ->
            checkRequiredParams(authorizationState)
        }
        .map { authorizationState ->
            when (authorizationState) {
                is TdApi.AuthorizationStateReady -> AuthState.LoggedIn
                is TdApi.AuthorizationStateWaitCode -> AuthState.EnterCode
                is TdApi.AuthorizationStateWaitPassword -> AuthState.EnterPassword(authorizationState.passwordHint)
                is TdApi.AuthorizationStateWaitPhoneNumber -> AuthState.EnterPhone
                else -> null
            }
        }

    suspend fun attachClient() {
        api.attachClient()
    }

    suspend fun sendPhone(phone: String) {
        api.setAuthenticationPhoneNumber(phone, null)
    }

    suspend fun sendCode(code: String) {
        api.checkAuthenticationCode(code)
    }

    suspend fun sendPassword(password: String) {
        api.checkAuthenticationPassword(password)
    }

    val userOnlineFlow: Flow<TdApi.User> = api.userStatusFlow().map { status ->
        api.getUser(status.userId)
    }

    private suspend fun checkRequiredParams(state: TdApi.AuthorizationState?) {
        if (state !is TdApi.AuthorizationStateWaitTdlibParameters) return

        api.setTdlibParameters(
            databaseDirectory = "/data/user/0/${BuildConfig.APPLICATION_ID}/files/td",
            useMessageDatabase = false,
            useSecretChats = false,
            useFileDatabase = true,
            systemLanguageCode = "en",
            deviceModel = "Android",
            systemVersion = "Example",
            applicationVersion = "1.1",
            apiId = BuildConfig.TELEGRAM_APP_ID,
            apiHash = BuildConfig.TELEGRAM_APP_HASH,
            useTestDc = false,
            filesDirectory = "/data/user/0/${BuildConfig.APPLICATION_ID}/files/td",
            databaseEncryptionKey = null,
            useChatInfoDatabase = false
        )
    }
}

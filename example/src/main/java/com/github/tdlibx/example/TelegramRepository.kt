package com.github.tdlibx.example

import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.telegram.flow.TelegramFlow
import org.drinkless.td.libcore.telegram.TdApi

object TelegramRepository : TelegramFlow() {

    val flow = TdApi.UpdateAuthorizationState()
        .asFlow()
        .map { it.authorizationState }
        .onEach {
            // send required parameters or use TelegramFlow.createClientWithParameters() instead
            checkRequiredParams(it)
        }
        .map {
            when (it) {
                is TdApi.AuthorizationStateReady -> AuthState.LoggedIn
                is TdApi.AuthorizationStateWaitCode -> AuthState.EnterCode
                is TdApi.AuthorizationStateWaitPassword -> AuthState.EnterPassword(
                    it.passwordHint
                )
                is TdApi.AuthorizationStateWaitPhoneNumber -> AuthState.EnterPhone
                else -> null
            }
        }

    val textMessagesFlow = TdApi.UpdateNewMessage().mapAsFlow {
        it.message.content
    }.filterIsInstance<TdApi.MessageText>().map { it.text.text }

    // send required parameters or pass them using TelegramFlow.createClientWithParameters() instead
    private suspend fun checkRequiredParams(it: TdApi.AuthorizationState?) {
        when (it) {
            is TdApi.AuthorizationStateWaitTdlibParameters ->
                TdApi.SetTdlibParameters(TelegramCredentials.parameters).expect<TdApi.Ok>()
            is TdApi.AuthorizationStateWaitEncryptionKey ->
                TdApi.CheckDatabaseEncryptionKey().expect<TdApi.Ok>()
        }
    }

    suspend fun sendPhone(phone: String) {
        TdApi.SetAuthenticationPhoneNumber(
            phone,
            null
        ).expect<TdApi.Ok>()
    }

    suspend fun sendCode(code: String) {
        TdApi.CheckAuthenticationCode(code)
            .expect<TdApi.Ok>()
    }

    suspend fun sendPassword(password: String) {
        TdApi.CheckAuthenticationPassword(
            password
        ).expect<TdApi.Ok>()
    }
}
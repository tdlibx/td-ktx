package com.github.tdlibx.example

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.telegram.core.TelegramFlow
import kotlinx.telegram.coroutines.checkAuthenticationCode
import kotlinx.telegram.coroutines.checkAuthenticationPassword
import kotlinx.telegram.coroutines.checkDatabaseEncryptionKey
import kotlinx.telegram.coroutines.getChat
import kotlinx.telegram.coroutines.getUser
import kotlinx.telegram.coroutines.setAuthenticationPhoneNumber
import kotlinx.telegram.coroutines.setTdlibParameters
import kotlinx.telegram.flows.authorizationStateFlow
import kotlinx.telegram.flows.newMessageFlow
import kotlinx.telegram.flows.userFlow
import kotlinx.telegram.extensions.ChatKtx
import kotlinx.telegram.extensions.UserKtx
import org.drinkless.td.libcore.telegram.TdApi

object TelegramRepository : UserKtx, ChatKtx {

    override val api = TelegramFlow()

    val flow = api.authorizationStateFlow()
        .onEach {
            // send required parameters or use TelegramFlow.createClientWithParameters() instead
            checkRequiredParams(it)
        }
        .map {
            when (it) {
                is TdApi.AuthorizationStateReady -> AuthState.LoggedIn
                is TdApi.AuthorizationStateWaitCode -> AuthState.EnterCode
                is TdApi.AuthorizationStateWaitPassword -> AuthState.EnterPassword(it.passwordHint)
                is TdApi.AuthorizationStateWaitPhoneNumber -> AuthState.EnterPhone
                else -> null
            }
        }


    // send required parameters or pass them using TelegramFlow.createClientWithParameters() instead
    private suspend fun checkRequiredParams(it: TdApi.AuthorizationState?) {
        when (it) {
            is TdApi.AuthorizationStateWaitTdlibParameters ->
                api.setTdlibParameters(TelegramCredentials.parameters)
            is TdApi.AuthorizationStateWaitEncryptionKey ->
                api.checkDatabaseEncryptionKey(null)
        }
    }

    suspend fun sendPhone(phone: String) {
        api.setAuthenticationPhoneNumber(phone, null)
    }

    suspend fun sendCode(code: String) {
        api.checkAuthenticationCode(code)
    }

    suspend fun sendPassword(password: String) {
        api.checkAuthenticationPassword(
            password
        )
    }
}

fun String.log() {
    Log.e("=========", this)
}
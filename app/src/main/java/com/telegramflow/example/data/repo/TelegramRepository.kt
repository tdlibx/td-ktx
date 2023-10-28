package com.telegramflow.example.data.repo

import com.telegramflow.example.data.local.AuthState
import com.telegramflow.example.data.local.TelegramCredentials
import kotlinx.coroutines.flow.flattenMerge
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.retryWhen
import kotlinx.telegram.core.TelegramException
import kotlinx.telegram.core.TelegramFlow
import kotlinx.telegram.coroutines.checkAuthenticationCode
import kotlinx.telegram.coroutines.checkAuthenticationPassword
import kotlinx.telegram.coroutines.checkDatabaseEncryptionKey
import kotlinx.telegram.coroutines.getChat
import kotlinx.telegram.coroutines.getChats
import kotlinx.telegram.coroutines.getMe
import kotlinx.telegram.coroutines.getMessage
import kotlinx.telegram.coroutines.getUser
import kotlinx.telegram.coroutines.setAuthenticationPhoneNumber
import kotlinx.telegram.coroutines.setTdlibParameters
import kotlinx.telegram.extensions.ChatKtx
import kotlinx.telegram.extensions.UserKtx
import kotlinx.telegram.flows.authorizationStateFlow
import kotlinx.telegram.flows.chatLastMessageFlow
import kotlinx.telegram.flows.userFlow
import kotlinx.telegram.flows.userStatusFlow
import org.drinkless.td.libcore.telegram.TdApi
import org.drinkless.td.libcore.telegram.TdApi.ChatListMain
import org.drinkless.td.libcore.telegram.TdApi.MessageText

// TODO Hilt injection
object TelegramRepository : UserKtx, ChatKtx {

    override val api: TelegramFlow = TelegramFlow()

    val authFlow = api.authorizationStateFlow()
        .onEach {
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

    private suspend fun checkRequiredParams(state: TdApi.AuthorizationState?) {
        when (state) {
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

    suspend fun searchMessages(page: Int, loadSize: Long): Any {
        val chats = api.getChats(ChatListMain(), page * loadSize, loadSize, 0)
        return chats.chatIds
    }

    suspend fun getRecentChats() {
        api.getChats(ChatListMain(), 0, 0, 10)
    }

    val userOnlineFlow = api.userStatusFlow().map {
        api.getUser(it.userId)
    }

    //chatmess huitter
    val messageFlow = api.chatLastMessageFlow().mapNotNull { message ->
        val chat = api.getChat(message.chatId)
        val messageText = message.lastMessage?.id?.let { api.getMessage(chat.id, it).content } as? MessageText
        messageText
    }

    val userInfoFlow = flowOf(
        api.userFlow(),
        api.userStatusFlow().map {
            api.getUser(it.userId)
        }
    ).flattenMerge().map { user: TdApi.User ->

        if (api.getMe().id == user.id) "it's me!"
        else {
            val userInfo = arrayListOf(user.firstName)

            if (user.getFullInfo().groupInCommonCount > 0) {
                user.getGroupsInCommon(0, 10).chatIds.map {
                    api.getChat(it).let { chat ->
                        val admins = chat.getAdministrators().administrators.map { admin ->
                            api.getUser(admin.userId).firstName
                        }.joinToString()
                        "    '${chat.title}'" +
                                (" admins: $admins".takeIf { admins.isNotBlank() } ?: "")
                    }
                }.joinToString("\n").let {
                    userInfo.add(" has chats in common:\n$it")
                }
            }

            userInfo.joinToString()
        }
    }.retryWhen { cause, _ -> cause is TelegramException }
}
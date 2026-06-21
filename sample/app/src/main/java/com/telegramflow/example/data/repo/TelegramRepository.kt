package com.telegramflow.example.data.repo

import com.telegramflow.example.BuildConfig
import com.telegramflow.example.data.local.AuthState
import com.telegramflow.example.data.local.TelegramConfigStorage
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.telegram.core.TelegramFlow
import kotlinx.telegram.flows.authorizationStateFlow
import kotlinx.telegram.flows.userStatusFlow
import org.drinkless.tdlib.generated.*

@Singleton
class TelegramRepository @Inject constructor(
    val api: TelegramFlow,
    private val configStorage: TelegramConfigStorage
) {

    val authFlow: Flow<AuthState?> = api.authorizationStateFlow()
        .onEach { authorizationState ->
            checkRequiredParams(authorizationState)
        }
        .map { authorizationState ->
            when (authorizationState) {
                is AuthorizationStateReady -> AuthState.LoggedIn
                is AuthorizationStateWaitCode -> AuthState.EnterCode
                is AuthorizationStateWaitPassword -> AuthState.EnterPassword(authorizationState.passwordHint.orEmpty())
                is AuthorizationStateWaitPhoneNumber -> AuthState.EnterPhone
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

    val userOnlineFlow: Flow<User> = api.userStatusFlow().map { status ->
        api.getUser(status.userId)
    }

    suspend fun fetchChats(chatList: ChatList? = null, limit: Int): Chats {
        return api.getChats(chatList = chatList, limit = limit)
    }

    suspend fun fetchChat(chatId: Long): Chat {
        return api.getChat(chatId)
    }

    suspend fun fetchMessage(chatId: Long, messageId: Long): Message {
        return api.getMessage(chatId = chatId, messageId = messageId)
    }

    suspend fun fetchMessageAddedReactions(
        chatId: Long,
        messageId: Long,
        reactionType: ReactionType? = null,
        offset: String = "",
        limit: Int = 100,
    ): AddedReactions {
        return api.getMessageAddedReactions(
            chatId = chatId,
            messageId = messageId,
            reactionType = reactionType,
            offset = offset,
            limit = limit,
        )
    }

    suspend fun fetchChatHistory(
        chatId: Long,
        fromMessageId: Long,
        offset: Int,
        limit: Int,
        onlyLocal: Boolean,
    ): Messages {
        return api.getChatHistory(
            chatId = chatId,
            fromMessageId = fromMessageId,
            offset = offset,
            limit = limit,
            onlyLocal = onlyLocal,
        )
    }

    suspend fun fetchUser(userId: Long): User {
        return api.getUser(userId)
    }

    suspend fun fetchUserByUsername(username: String): User? {
        return runCatching {
            val chat = api.searchPublicChat(username)
            val userId = (chat.type as? ChatTypePrivate)?.userId ?: return null
            api.getUser(userId)
        }.getOrNull()
    }

    suspend fun downloadFile(
        fileId: Int,
        priority: Int = 1,
        offset: Long = 0,
        limit: Long = 0,
        synchronous: Boolean = true,
    ): File {
        return api.downloadFile(
            fileId = fileId,
            priority = priority,
            offset = offset,
            limit = limit,
            synchronous = synchronous,
        )
    }

    private suspend fun checkRequiredParams(state: AuthorizationState?) {
        if (state !is AuthorizationStateWaitTdlibParameters) return

        api.setTdlibParameters(
            databaseDirectory = "/data/user/0/${BuildConfig.APPLICATION_ID}/files/td",
            useMessageDatabase = false,
            useSecretChats = false,
            useFileDatabase = true,
            systemLanguageCode = "en",
            deviceModel = "Android",
            systemVersion = "Example",
            applicationVersion = "1.1",
            apiId = configStorage.appId,
            apiHash = configStorage.appHash ?: "",
            useTestDc = false,
            filesDirectory = "/data/user/0/${BuildConfig.APPLICATION_ID}/files/td",
            databaseEncryptionKey = null,
            useChatInfoDatabase = false
        )
    }
}

package com.telegramflow.example.data.repo

import android.content.Context
import android.util.Log
import com.telegramflow.example.data.local.AuthState
import com.telegramflow.example.data.local.TelegramConfigStorage
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.telegram.core.TelegramFlow
import kotlinx.telegram.flows.authorizationStateFlow
import kotlinx.telegram.flows.userStatusFlow
import org.drinkless.tdlib.generated.*

@Singleton
class TelegramRepository @Inject constructor(
    val api: TelegramFlow,
    private val configStorage: TelegramConfigStorage,
    @ApplicationContext private val context: Context,
) {
    private val tdDirectory = context.filesDir.resolve("td").apply { mkdirs() }

    // Long-lived scope: survives as long as the @Singleton, so the eager StateFlow
    // keeps collecting for the entire app lifetime.
    private val repositoryScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    /**
     * Hot [StateFlow] that always holds the latest TDLib authorization state mapped to [AuthState].
     *
     * Started *eagerly* so collection begins at injection time — before any UI subscriber exists.
     * This prevents missing [AuthorizationStateWaitPhoneNumber] (and other auth transitions) that
     * TDLib fires immediately after [AuthorizationStateWaitTdlibParameters] is handled.
     *
     * Previous bug: [authorizationStateFlow] was a cold [Flow]. TDLib would fire WaitPhoneNumber
     * before the LoginScreen composed, and since [TdKtxClient.updates] has only replay=1 (raw JSON),
     * any subsequent unrelated update (e.g. updateOption) would evict the auth event from the buffer.
     */
    val authFlow: StateFlow<AuthState?> = api.authorizationStateFlow()
        .onEach { authorizationState ->
            checkRequiredParams(authorizationState)
        }.mapNotNull { authorizationState ->
            val mapped = when (authorizationState) {
                is AuthorizationStateReady -> AuthState.LoggedIn
                is AuthorizationStateWaitCode -> AuthState.EnterCode
                is AuthorizationStateWaitPassword -> AuthState.EnterPassword(authorizationState.passwordHint.orEmpty())
                is AuthorizationStateWaitPhoneNumber -> AuthState.EnterPhone
                else -> null
            }
            mapped
        }
        .stateIn(
            scope = repositoryScope,
            started = SharingStarted.Eagerly,
            initialValue = null,
        )

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
            databaseDirectory = tdDirectory.absolutePath,
            useMessageDatabase = false,
            useSecretChats = false,
            useFileDatabase = true,
            systemLanguageCode = "en",
            deviceModel = "Android",
            systemVersion = "Example",
            applicationVersion = "1.1",
            apiId = configStorage.appId,
            apiHash = configStorage.appHash ?: "",
            useTestDc = configStorage.useTestDc,
            filesDirectory = tdDirectory.absolutePath,
            databaseEncryptionKey = null,
            useChatInfoDatabase = false
        )
    }
}

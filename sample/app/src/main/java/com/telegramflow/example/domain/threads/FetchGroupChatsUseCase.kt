package com.telegramflow.example.domain.threads

import android.util.Log
import com.telegramflow.example.data.repo.TelegramRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.drinkless.tdlib.TdApi

@Singleton
class FetchGroupChatsUseCase @Inject constructor(
    private val telegramRepository: TelegramRepository,
) {
    suspend operator fun invoke(): List<TdApi.Chat> = withContext(Dispatchers.IO) {
        val chatsResult = telegramRepository.fetchChats(chatList = null, limit = CHAT_LIMIT)
        val chats = chatsResult.chatIds ?: longArrayOf()
        Log.d(TAG, "Fetched chat ids count: ${chats.size}")

        chats.toList().mapNotNull { chatId ->
            runCatching { telegramRepository.fetchChat(chatId) }
                .getOrNull()
                ?.takeIf { chat ->
                    when (val type = chat.type) {
                        is TdApi.ChatTypeSupergroup -> !type.isChannel
                        is TdApi.ChatTypeBasicGroup -> true
                        else -> false
                    }
                }
        }
    }

    companion object {
        private const val CHAT_LIMIT = 100
        private const val TAG = "FetchGroupChatsUseCase"
    }
}

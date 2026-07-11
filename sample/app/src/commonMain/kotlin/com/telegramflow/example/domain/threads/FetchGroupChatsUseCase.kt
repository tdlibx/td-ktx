package com.telegramflow.example.domain.threads

import com.telegramflow.example.data.repo.TelegramRepository
import com.telegramflow.example.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import org.drinkless.tdlib.generated.*

class FetchGroupChatsUseCase(
    private val telegramRepository: TelegramRepository,
) {
    suspend operator fun invoke(): List<Chat> = withContext(Dispatchers.IO) {
        val chatsResult = telegramRepository.fetchChats(chatList = null, limit = CHAT_LIMIT)
        val chats = chatsResult.chatIds ?: emptyList()
        Log.d(TAG, "Fetched chat ids count: ${chats.size}")

        chats.mapNotNull { chatId ->
            try {
                telegramRepository.fetchChat(chatId)
                    .takeIf { chat ->
                        when (val type = chat.type) {
                            is ChatTypeSupergroup -> !type.isChannel
                            is ChatTypeBasicGroup -> true
                            else -> false
                        }
                    }
            } catch (e: Exception) {
                null
            }
        }
    }

    companion object {
        private const val CHAT_LIMIT = 100
        private const val TAG = "FetchGroupChatsUseCase"
    }
}

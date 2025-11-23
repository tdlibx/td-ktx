package com.telegramflow.example.ui.screen.threads

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.telegram.core.TelegramFlow
import kotlinx.telegram.coroutines.getChat
import kotlinx.telegram.coroutines.getChatHistory
import kotlinx.telegram.coroutines.getChats
import org.drinkless.tdlib.TdApi

@HiltViewModel
class ThreadsViewModel @Inject constructor(
    private val telegramFlow: TelegramFlow,
) : ViewModel() {

    private val _uiState: MutableStateFlow<ThreadsUiState> = MutableStateFlow(ThreadsUiState())
    val uiState: StateFlow<ThreadsUiState> = _uiState.asStateFlow()

    init {
        loadThreads()
    }

    fun loadThreads() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }

            try {
                val threads = fetchThreads()
                _uiState.value = ThreadsUiState(threads = threads, isLoading = false)
            } catch (throwable: Throwable) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = throwable.message ?: "Unable to load threads"
                    )
                }
            }
        }
    }

    private suspend fun fetchThreads(): List<ThreadUiModel> = withContext(Dispatchers.IO) {
        val chats = telegramFlow.getChats(chatList = null, limit = CHAT_LIMIT).chatIds
            ?: longArrayOf()
        val groups = chats.toList().mapNotNull { chatId ->
            telegramFlow.getChat(chatId).takeIf { chat ->
                when (val type = chat.type) {
                    is TdApi.ChatTypeSupergroup -> !type.isChannel
                    is TdApi.ChatTypeBasicGroup -> true
                    else -> false
                }
            }
        }

        val weekAgoInSeconds = (System.currentTimeMillis() / 1000) - SEVEN_DAYS_IN_SECONDS

        val deferredMessages = groups.map { chat ->
            async {
                telegramFlow.getChatHistory(
                    chatId = chat.id,
                    fromMessageId = 0,
                    offset = 0,
                    limit = HISTORY_LIMIT,
                    onlyLocal = false
                ).messages.orEmpty()
                    .filter { message ->
                        val replyCount = message.interactionInfo?.replyInfo?.replyCount ?: 0
                        message.date.toLong() >= weekAgoInSeconds && replyCount > MIN_REPLY_COUNT
                    }
                    .map { message ->
                        ThreadUiModel(
                            id = message.id,
                            chatId = chat.id,
                            chatTitle = chat.title,
                            text = messageText(message),
                            replyCount = message.interactionInfo?.replyInfo?.replyCount ?: 0,
                            date = message.date.toLong()
                        )
                    }
            }
        }

        deferredMessages.awaitAll()
            .flatten()
            .sortedByDescending { it.date }
    }

    private fun messageText(message: TdApi.Message): String {
        val content = message.content
        return when (content) {
            is TdApi.MessageText -> content.text?.text.orEmpty()
            is TdApi.MessagePhoto -> content.caption?.text?.takeIf { it.isNotBlank() } ?: "Photo"
            is TdApi.MessageVideo -> content.caption?.text?.takeIf { it.isNotBlank() } ?: "Video"
            is TdApi.MessageAnimation -> content.caption?.text?.takeIf { it.isNotBlank() } ?: "Animation"
            is TdApi.MessageAudio -> content.caption?.text?.takeIf { it.isNotBlank() } ?: "Audio"
            else -> content.javaClass.simpleName
        }
    }

    companion object {
        private const val SEVEN_DAYS_IN_SECONDS = 7 * 24 * 60 * 60
        private const val HISTORY_LIMIT = 100
        private const val CHAT_LIMIT = 100
        private const val MIN_REPLY_COUNT = 2
    }
}

data class ThreadUiModel(
    val id: Long,
    val chatId: Long,
    val chatTitle: String,
    val text: String,
    val replyCount: Int,
    val date: Long,
)

data class ThreadsUiState(
    val threads: List<ThreadUiModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)

package com.telegramflow.example.ui.screen.threads

import android.util.Log
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
import kotlinx.telegram.coroutines.getMessageThreadHistory
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
            Log.d(TAG, "Starting to load threads")

            try {
                val threads = fetchThreads()
                Log.d(TAG, "Threads loaded successfully: ${threads.size} items")
                _uiState.value = ThreadsUiState(threads = threads, isLoading = false)
            } catch (throwable: Throwable) {
                Log.e(TAG, "Failed to load threads", throwable)
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
        val chatsResult = telegramFlow.getChats(chatList = null, limit = CHAT_LIMIT)
        val chats = chatsResult.chatIds ?: longArrayOf()
        Log.d(TAG, "Fetched chat ids count: ${chats.size}")
        val groups = chats.toList().mapNotNull { chatId ->
            telegramFlow.getChat(chatId).takeIf { chat ->
                when (val type = chat.type) {
                    is TdApi.ChatTypeSupergroup -> !type.isChannel
                    is TdApi.ChatTypeBasicGroup -> true
                    else -> false
                }
            }
        }
        Log.d(TAG, "Filtered group chats count: ${groups.size}")

        val deferredMessages = groups.map { chat ->
            async {
                Log.d(TAG, "Fetching history for chat '${chat.title}' (${chat.id})")
                var fromMessageId = 0L
                var totalHistoryMessages = 0
                var page = 0
                val threadCandidates = mutableListOf<ThreadUiModel>()
                val seenMessageIds = mutableSetOf<Long>()

                while (page < MAX_HISTORY_PAGES && totalHistoryMessages < HISTORY_LIMIT) {
                    val history = telegramFlow.getChatHistory(
                        chatId = chat.id,
                        fromMessageId = fromMessageId,
                        offset = if (page == 0) 0 else -1,
                        limit = HISTORY_LIMIT,
                        onlyLocal = false
                    ).messages.orEmpty()

                    totalHistoryMessages += history.size
                    Log.d(
                        TAG,
                        "History page=$page for '${chat.title}' size=${history.size} fromMessageId=$fromMessageId"
                    )

                    if (history.isEmpty()) break

                    history.filter { message ->
                        val replyCount = message.interactionInfo?.replyInfo?.replyCount ?: 0
                        val isThreadCandidate = replyCount > MIN_REPLY_COUNT
                        if (isThreadCandidate) {
                            Log.d(
                                TAG,
                                "Thread candidate in '${chat.title}': messageId=${message.id}, replies=$replyCount"
                            )
                        }
                        isThreadCandidate
                    }.forEach { message ->
                        if (seenMessageIds.add(message.id)) {
                            val threadHistory = runCatching {
                                telegramFlow.getMessageThreadHistory(
                                    chatId = chat.id,
                                    messageId = message.id,
                                    fromMessageId = 0,
                                    offset = 0,
                                    limit = THREAD_REPLY_LIMIT
                                ).messages.orEmpty()
                            }.onFailure {
                                Log.w(
                                    TAG,
                                    "getMessageThreadHistory failed for messageId=${message.id} in '${chat.title}'",
                                    it
                                )
                            }.getOrElse { emptyList() }

                            val threadReplyCount = maxOf(
                                message.interactionInfo?.replyInfo?.replyCount ?: 0,
                                // +1 to include the root message if the API excludes it
                                (threadHistory.size - 1).coerceAtLeast(0)
                            )

                            if (threadReplyCount > MIN_REPLY_COUNT) {
                                Log.d(
                                    TAG,
                                    "Confirmed thread in '${chat.title}': messageId=${message.id}, replies=$threadReplyCount"
                                )

                                threadCandidates += ThreadUiModel(
                                    id = message.id,
                                    chatId = chat.id,
                                    chatTitle = chat.title,
                                    text = messageText(message),
                                    replyCount = threadReplyCount,
                                    date = message.date.toLong()
                                )
                            } else {
                                Log.d(
                                    TAG,
                                    "Discarded candidate after thread fetch '${chat.title}': messageId=${message.id}, replies=$threadReplyCount"
                                )
                            }
                        } else {
                            Log.d(
                                TAG,
                                "Duplicate message skipped in '${chat.title}': messageId=${message.id}"
                            )
                        }
                    }

                    val lastMessage = history.last()
                    if (totalHistoryMessages >= HISTORY_LIMIT || history.size < HISTORY_LIMIT) break
                    fromMessageId = lastMessage.id
                    page++
                }

                Log.d(
                    TAG,
                    "Finished '${chat.title}': scanned=$totalHistoryMessages, threads=${threadCandidates.size}"
                )

                threadCandidates
            }
        }

        val results = deferredMessages.awaitAll()
            .flatten()
            .distinctBy { it.chatId to it.id }
            .sortedByDescending { it.date }

        Log.d(TAG, "Total threads found: ${results.size}")
        results
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
        private const val HISTORY_LIMIT = 100
        private const val CHAT_LIMIT = 100
        private const val MAX_HISTORY_PAGES = 5
        private const val MIN_REPLY_COUNT = 2
        private const val THREAD_REPLY_LIMIT = 100
        private const val TAG = "ThreadsViewModel"
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

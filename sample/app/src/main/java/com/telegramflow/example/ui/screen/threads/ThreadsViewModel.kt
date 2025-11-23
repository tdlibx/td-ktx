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
                val messagesById = mutableMapOf<Long, TdApi.Message>()
                val repliesByParent = mutableMapOf<Long, MutableList<TdApi.Message>>()

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

                    history.forEach { message ->
                        if (seenMessageIds.add(message.id)) {
                            messagesById[message.id] = message
                            replyToMessageId(message)?.let { parentId ->
                                repliesByParent.getOrPut(parentId) { mutableListOf() }.add(message)
                            }
                        }
                    }

                    val lastMessage = history.last()
                    if (totalHistoryMessages >= HISTORY_LIMIT || history.size < HISTORY_LIMIT) break
                    fromMessageId = lastMessage.id
                    page++
                }

                val threadRoots = repliesByParent.keys.mapNotNull { messagesById[it] }
                Log.d(
                    TAG,
                    "Collected ${messagesById.size} messages with ${threadRoots.size} potential roots in '${chat.title}'"
                )

                threadRoots.forEach { root ->
                    val flattenedReplies = collectReplies(
                        parentId = root.id,
                        repliesByParent = repliesByParent,
                        depth = 1
                    )
                    val totalReplies = flattenedReplies.size
                    if (totalReplies > MIN_REPLY_COUNT) {
                        threadCandidates += ThreadUiModel(
                            id = root.id,
                            chatId = chat.id,
                            chatTitle = chat.title,
                            text = messageText(root),
                            replyCount = totalReplies,
                            date = root.date.toLong(),
                            replies = flattenedReplies
                        )
                        Log.d(
                            TAG,
                            "Thread found in '${chat.title}': rootId=${root.id}, replies=$totalReplies"
                        )
                    } else {
                        Log.d(
                            TAG,
                            "Skipped root ${root.id} in '${chat.title}' with replies=$totalReplies"
                        )
                    }
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

    private fun collectReplies(
        parentId: Long,
        repliesByParent: Map<Long, List<TdApi.Message>>,
        depth: Int,
    ): List<ThreadReplyUiModel> {
        val replies = repliesByParent[parentId].orEmpty().sortedBy { it.date }
        val replyItems = mutableListOf<ThreadReplyUiModel>()
        replies.forEach { reply ->
            replyItems += ThreadReplyUiModel(
                id = reply.id,
                chatId = reply.chatId,
                text = messageText(reply),
                depth = depth,
                date = reply.date.toLong()
            )
            replyItems += collectReplies(
                parentId = reply.id,
                repliesByParent = repliesByParent,
                depth = depth + 1
            )
        }
        return replyItems
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

    private fun replyToMessageId(message: TdApi.Message): Long? {
        return when (val reply = message.replyTo) {
            is TdApi.MessageReplyToMessage -> reply.messageId
            else -> null
        }
    }

    companion object {
        private const val HISTORY_LIMIT = 100
        private const val CHAT_LIMIT = 100
        private const val MAX_HISTORY_PAGES = 5
        private const val MIN_REPLY_COUNT = 2
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
    val replies: List<ThreadReplyUiModel> = emptyList(),
)

data class ThreadReplyUiModel(
    val id: Long,
    val chatId: Long,
    val text: String,
    val depth: Int,
    val date: Long,
)

data class ThreadsUiState(
    val threads: List<ThreadUiModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)

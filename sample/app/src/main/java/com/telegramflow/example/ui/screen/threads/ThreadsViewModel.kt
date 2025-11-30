package com.telegramflow.example.ui.screen.threads

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.telegramflow.example.domain.threads.BuildThreadsForChatUseCase
import com.telegramflow.example.domain.threads.FetchGroupChatsUseCase
import com.telegramflow.example.domain.threads.ThreadUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class ThreadsViewModel @Inject constructor(
    private val fetchGroupChats: FetchGroupChatsUseCase,
    private val buildThreadsForChat: BuildThreadsForChatUseCase,
) : ViewModel() {

    private val _uiState: MutableStateFlow<ThreadsUiState> = MutableStateFlow(ThreadsUiState())
    val uiState: StateFlow<ThreadsUiState> = _uiState.asStateFlow()

    init {
        loadThreads()
    }

    fun loadThreads() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null, threads = emptyList()) }
            Log.d(TAG, "Starting to load threads")

            try {
                val groups = fetchGroupChats()
                Log.d(TAG, "Filtered group chats count: ${groups.size}")

                val deferredMessages = groups.map { chat ->
                    async(Dispatchers.IO) { buildThreadsForChat(chat) }
                }

                var firstError: Throwable? = null
                deferredMessages.forEach { deferred ->
                    try {
                        val chatThreads = deferred.await()
                        if (chatThreads.isNotEmpty()) {
                            _uiState.update { state ->
                                val merged = (state.threads + chatThreads)
                                    .distinctBy { it.chatId to it.id }
                                    .sortedByDescending { it.date }
                                state.copy(threads = merged)
                            }
                        }
                    } catch (throwable: Throwable) {
                        Log.e(TAG, "Failed to load a chat's threads", throwable)
                        if (firstError == null) firstError = throwable
                    }
                }

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = firstError?.message
                    )
                }
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

    companion object {
        private const val TAG = "ThreadsViewModel"
    }
}

data class ThreadsUiState(
    val threads: List<ThreadUiModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)

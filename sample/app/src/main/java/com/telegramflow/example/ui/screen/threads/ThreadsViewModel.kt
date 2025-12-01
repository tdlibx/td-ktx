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
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.joinAll

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

                var firstError: Throwable? = null
                val jobs = groups.map { chat ->
                    viewModelScope.launch(Dispatchers.IO) {
                        try {
                            buildThreadsForChat(chat).collect { thread ->
                                _uiState.update { state ->
                                    val threads = state.threads.toMutableList()
                                    val existingIndex = threads.indexOfFirst {
                                        it.chatId == thread.chatId && it.id == thread.id
                                    }
                                    if (existingIndex >= 0) {
                                        threads.removeAt(existingIndex)
                                    }

                                    val insertIndex = threads.indexOfFirst {
                                        it.lastMessageDate < thread.lastMessageDate
                                    }
                                    if (insertIndex >= 0) {
                                        threads.add(insertIndex, thread)
                                    } else {
                                        threads.add(thread)
                                    }

                                    state.copy(threads = threads)
                                }
                            }
                        } catch (throwable: Throwable) {
                            Log.e(TAG, "Failed to load a chat's threads", throwable)
                            if (firstError == null) firstError = throwable
                        }
                    }
                }

                jobs.joinAll()

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

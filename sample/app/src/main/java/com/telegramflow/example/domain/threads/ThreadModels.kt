package com.telegramflow.example.domain.threads

/**
 * Thread models shared between repository and UI layers.
 */
data class ThreadUiModel(
    val id: Long,
    val chatId: Long,
    val chatTitle: String,
    val senderName: String,
    val text: String,
    val photoPath: String? = null,
    val replyCount: Int,
    val date: Long,
    val replies: List<ThreadReplyUiModel> = emptyList(),
)

data class ThreadReplyUiModel(
    val id: Long,
    val chatId: Long,
    val senderName: String,
    val text: String,
    val photoPath: String? = null,
    val depth: Int,
    val date: Long,
)

package com.telegramflow.example.domain.threads

import androidx.compose.ui.text.AnnotatedString

/**
 * Thread models shared between repository and UI layers.
 */
data class ThreadUiModel(
    val id: Long,
    val chatId: Long,
    val chatTitle: String,
    val chatAvatarPath: String? = null,
    val senderName: String,
    val text: String,
    val richText: AnnotatedString? = null,
    val photoPath: String? = null,
    val reactions: List<ReactionUiModel> = emptyList(),
    val replyCount: Int,
    val date: Long,
    val replies: List<ThreadReplyUiModel> = emptyList(),
    val isComplete: Boolean = true,
)

data class ThreadReplyUiModel(
    val id: Long,
    val chatId: Long,
    val senderName: String,
    val text: String,
    val richText: AnnotatedString? = null,
    val photoPath: String? = null,
    val reactions: List<ReactionUiModel> = emptyList(),
    val depth: Int,
    val date: Long,
)

data class ReactionUiModel(
    val label: String,
    val count: Int,
)

const val THREAD_URL_TAG = "URL"

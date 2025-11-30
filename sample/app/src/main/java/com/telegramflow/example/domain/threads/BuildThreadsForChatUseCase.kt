package com.telegramflow.example.domain.threads

import android.util.Log
import com.telegramflow.example.data.repo.TelegramRepository
import com.telegramflow.example.domain.threads.ReactionUiModel
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.drinkless.tdlib.TdApi

@Singleton
class BuildThreadsForChatUseCase @Inject constructor(
    private val telegramRepository: TelegramRepository,
) {
    operator fun invoke(chat: TdApi.Chat): Flow<ThreadUiModel> = flow {
        Log.d(TAG, "Fetching history for chat '${chat.title}' (${chat.id})")
        var fromMessageId = 0L
        var totalHistoryMessages = 0
        var page = 0
        val seenMessageIds = mutableSetOf<Long>()
        val messagesById = mutableMapOf<Long, TdApi.Message>()
        val repliesByParent = mutableMapOf<Long, MutableList<TdApi.Message>>()
        val userNames = mutableMapOf<Long, String>()
        val chatNames = mutableMapOf<Long, String>()
        val filePaths = mutableMapOf<Int, String?>()

        while (page < MAX_HISTORY_PAGES && totalHistoryMessages < HISTORY_LIMIT) {
            val history = telegramRepository.fetchChatHistory(
                chatId = chat.id,
                fromMessageId = fromMessageId,
                offset = 0,
                limit = HISTORY_LIMIT,
                onlyLocal = false,
            ).messages.orEmpty()

            totalHistoryMessages += history.size
            Log.d(
                TAG,
                "History page=$page for '${chat.title}' size=${history.size} fromMessageId=$fromMessageId",
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
            fromMessageId = lastMessage.id
            page++
        }

        val repliedMessageIds = repliesByParent.values.flatten().map { it.id }.toSet()
        val threadRoots = repliesByParent.keys
            .filterNot { it in repliedMessageIds }
            .mapNotNull { messagesById[it] }
        Log.d(
            TAG,
            "Collected ${messagesById.size} messages with ${threadRoots.size} potential roots in '${chat.title}'",
        )

        threadRoots.forEach { root ->
            val previewReplies = collectReplies(
                parentId = root.id,
                repliesByParent = repliesByParent,
                depth = 1,
                userNames = userNames,
                chatNames = chatNames,
                filePaths = filePaths,
                shallow = true,
                downloadMedia = false,
            )
            val totalReplies = countReplies(root.id, repliesByParent)

            if (totalReplies > MIN_REPLY_COUNT) {
                emit(
                    ThreadUiModel(
                        id = root.id,
                        chatId = chat.id,
                        chatTitle = chat.title,
                        senderName = resolveSenderName(root, userNames, chatNames),
                        text = messageText(root),
                        reactions = mapReactions(root),
                        replyCount = totalReplies,
                        date = root.date.toLong(),
                        replies = previewReplies.take(PREVIEW_REPLY_LIMIT),
                        isComplete = false,
                    ),
                )

                val flattenedReplies = collectReplies(
                    parentId = root.id,
                    repliesByParent = repliesByParent,
                    depth = 1,
                    userNames = userNames,
                    chatNames = chatNames,
                    filePaths = filePaths,
                    shallow = false,
                    downloadMedia = true,
                )
                emit(
                    ThreadUiModel(
                        id = root.id,
                        chatId = chat.id,
                        chatTitle = chat.title,
                        chatAvatarPath = resolveChatAvatar(chat, filePaths),
                        senderName = resolveSenderName(root, userNames, chatNames),
                        text = messageText(root),
                        photoPath = resolvePhotoPath(root, filePaths),
                        reactions = mapReactions(root),
                        replyCount = totalReplies,
                        date = root.date.toLong(),
                        replies = flattenedReplies,
                        isComplete = true,
                    ),
                )
                Log.d(
                    TAG,
                    "Thread found in '${chat.title}': rootId=${root.id}, replies=$totalReplies",
                )
            } else {
                Log.d(
                    TAG,
                    "Skipped root ${root.id} in '${chat.title}' with replies=$totalReplies",
                )
            }
        }

        Log.d(
            TAG,
            "Finished '${chat.title}': scanned=$totalHistoryMessages, threads=${threadRoots.size}",
        )
    }.flowOn(Dispatchers.IO)

    private fun countReplies(
        parentId: Long,
        repliesByParent: Map<Long, List<TdApi.Message>>,
    ): Int {
        val replies = repliesByParent[parentId].orEmpty()
        return replies.size + replies.sumOf { reply -> countReplies(reply.id, repliesByParent) }
    }

    private suspend fun collectReplies(
        parentId: Long,
        repliesByParent: Map<Long, List<TdApi.Message>>,
        depth: Int,
        userNames: MutableMap<Long, String>,
        chatNames: MutableMap<Long, String>,
        filePaths: MutableMap<Int, String?>,
        shallow: Boolean,
        downloadMedia: Boolean,
    ): List<ThreadReplyUiModel> {
        val replies = repliesByParent[parentId].orEmpty().sortedBy { it.date }
        val replyItems = mutableListOf<ThreadReplyUiModel>()
        replies.take(if (shallow) PREVIEW_REPLY_LIMIT else replies.size).forEach { reply ->
            replyItems += ThreadReplyUiModel(
                id = reply.id,
                chatId = reply.chatId,
                senderName = resolveSenderName(reply, userNames, chatNames),
                text = messageText(reply),
                photoPath = if (downloadMedia) resolvePhotoPath(reply, filePaths) else null,
                reactions = mapReactions(reply),
                depth = depth,
                date = reply.date.toLong(),
            )
            if (!shallow) {
                replyItems += collectReplies(
                    parentId = reply.id,
                    repliesByParent = repliesByParent,
                    depth = depth + 1,
                    userNames = userNames,
                    chatNames = chatNames,
                    filePaths = filePaths,
                    shallow = false,
                    downloadMedia = downloadMedia,
                )
            }
        }
        return replyItems
    }

    private suspend fun resolvePhotoPath(
        message: TdApi.Message,
        filePaths: MutableMap<Int, String?>,
    ): String? {
        val content = message.content as? TdApi.MessagePhoto ?: return null
        val bestSize = content.photo?.sizes?.maxByOrNull { it.photo?.expectedSize ?: 0L }
        val file = bestSize?.photo ?: return null

        return filePaths.getOrPut(file.id) {
            runCatching { downloadPhoto(file) }.getOrNull()
        }
    }

    private suspend fun downloadPhoto(file: TdApi.File): String? {
        val completedLocalPath = file.local?.takeIf { it.isDownloadingCompleted }?.path
            ?.takeIf { it.isNotBlank() }
        if (completedLocalPath != null) return completedLocalPath

        val downloaded = telegramRepository.downloadFile(
            fileId = file.id,
            priority = 1,
            offset = 0L,
            limit = 0L,
            synchronous = true,
        )

        return downloaded.local?.takeIf { it.isDownloadingCompleted }?.path
            ?.takeIf { it.isNotBlank() }
    }

    private suspend fun resolveChatAvatar(
        chat: TdApi.Chat,
        filePaths: MutableMap<Int, String?>,
    ): String? {
        val file = chat.photo?.small ?: return null
        return filePaths.getOrPut(file.id) {
            runCatching {
                telegramRepository.downloadFile(
                    fileId = file.id,
                    priority = 1,
                    offset = 0L,
                    limit = 0L,
                    synchronous = true,
                ).local?.takeIf { it.isDownloadingCompleted }?.path
                    ?.takeIf { it.isNotBlank() }
            }.getOrNull()
        }
    }

    private fun mapReactions(message: TdApi.Message): List<ReactionUiModel> {
        val reactionCounts = message.interactionInfo?.reactions?.reactions.orEmpty()
        return reactionCounts.mapNotNull { reactionCount ->
            val label = reactionLabel(reactionCount.type) ?: return@mapNotNull null
            ReactionUiModel(label = label, count = reactionCount.totalCount)
        }
    }

    private fun reactionLabel(reaction: TdApi.ReactionType): String? {
        return when (reaction) {
            is TdApi.ReactionTypeEmoji -> reaction.emoji
            is TdApi.ReactionTypeCustomEmoji -> "Custom"
            else -> null
        }
    }

    private suspend fun resolveSenderName(
        message: TdApi.Message,
        userNames: MutableMap<Long, String>,
        chatNames: MutableMap<Long, String>,
    ): String {
        return when (val sender = message.senderId) {
            is TdApi.MessageSenderUser -> {
                val userId = sender.userId
                userNames.getOrPut(userId) {
                    runCatching { telegramRepository.fetchUser(userId) }
                        .getOrNull()
                        ?.let { user ->
                            listOfNotNull(user.firstName, user.lastName)
                                .filter { it.isNotBlank() }
                                .joinToString(" ")
                                .ifBlank { user.usernames?.activeUsernames?.firstOrNull().orEmpty() }
                        }
                        ?.takeIf { it.isNotBlank() }
                        ?: "Unknown"
                }
            }
            is TdApi.MessageSenderChat -> {
                val senderChatId = sender.chatId
                chatNames.getOrPut(senderChatId) {
                    runCatching { telegramRepository.fetchChat(senderChatId) }
                        .getOrNull()
                        ?.title
                        ?.takeIf { it.isNotBlank() }
                        ?: "Unknown"
                }
            }
            else -> "Unknown"
        }
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
        private const val MAX_HISTORY_PAGES = 5
        private const val MIN_REPLY_COUNT = 2
        private const val PREVIEW_REPLY_LIMIT = 3
        private const val TAG = "BuildThreadsForChatUseCase"
    }
}

package com.telegramflow.example.ui.screen.threads

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.telegramflow.example.data.repo.LocalTelegramRepository
import com.telegramflow.example.domain.threads.ReactionUiModel
import com.telegramflow.example.domain.threads.THREAD_URL_TAG
import com.telegramflow.example.domain.threads.ThreadReplyUiModel
import com.telegramflow.example.domain.threads.ThreadUiModel
import com.telegramflow.example.domain.threads.FetchGroupChatsUseCase
import com.telegramflow.example.domain.threads.BuildThreadsForChatUseCase
import com.telegramflow.example.ui.components.LocalImage
import com.telegramflow.example.util.formatThreadDateRange

@Composable
fun ThreadsScreen(
    presenter: ThreadsPresenter = run {
        val repo = LocalTelegramRepository.current
        val scope = rememberCoroutineScope()
        remember(repo, scope) {
            val fetchUseCase = FetchGroupChatsUseCase(repo)
            val buildUseCase = BuildThreadsForChatUseCase(repo)
            ThreadsPresenter(fetchUseCase, buildUseCase, scope)
        }
    }
) {
    val uiState by presenter.uiState.collectAsState()

    when {
        uiState.threads.isNotEmpty() -> {
            ThreadsList(threads = uiState.threads, isLoading = uiState.isLoading)
        }

        uiState.isLoading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        uiState.error != null -> {
            ErrorState(message = uiState.error.orEmpty(), onRetry = presenter::loadThreads)
        }

        else -> {
            EmptyState()
        }
    }
}

@Composable
private fun ThreadsList(threads: List<ThreadUiModel>, isLoading: Boolean) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(threads, key = { thread -> "${thread.chatId}_${thread.id}" }) { thread ->
            ThreadItem(thread)
        }

        if (isLoading) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

@Composable
private fun ThreadItem(thread: ThreadUiModel) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                ChatAvatar(avatarPath = thread.chatAvatarPath, fallbackName = thread.chatTitle)
                Spacer(modifier = Modifier.size(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = thread.chatTitle,
                        style = MaterialTheme.typography.titleMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "${thread.replyCount} replies",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.size(8.dp))

                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = formatThreadDateRange(thread.firstMessageDate, thread.lastMessageDate),
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                if (!thread.isComplete) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(22.dp),
                        strokeWidth = 2.dp,
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            ThreadMessage(
                name = thread.senderName,
                text = thread.text,
                richText = thread.richText,
                photoPath = thread.photoPath,
                reactions = thread.reactions,
                style = MaterialTheme.typography.bodyLarge
            )

            if (!thread.isComplete) {
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    LinearProgressIndicator(modifier = Modifier.weight(1f))
                    Text(
                        text = "Loading details…",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            if (thread.replies.isNotEmpty()) {
                Spacer(modifier = Modifier.height(12.dp))
                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Replies (${thread.replyCount})",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(8.dp))
                RepliesList(thread.replies)
            }
        }
    }
}

@Composable
private fun RepliesList(replies: List<ThreadReplyUiModel>) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        replies.forEach { reply ->
            ReplyItem(reply)
        }
    }
}

@Composable
private fun ReplyItem(reply: ThreadReplyUiModel) {
    val indent = (reply.depth * 14).dp
    Row(
        modifier = Modifier
            .padding(start = indent)
            .height(IntrinsicSize.Min)
    ) {
        Box(
            modifier = Modifier
                .width(2.dp)
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.outlineVariant)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            ThreadMessage(
                name = reply.senderName,
                text = reply.text,
                richText = reply.richText,
                photoPath = reply.photoPath,
                reactions = reply.reactions,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ThreadMessage(
    name: String,
    text: String,
    richText: AnnotatedString?,
    photoPath: String?,
    reactions: List<ReactionUiModel>,
    style: androidx.compose.ui.text.TextStyle,
) {
    val uriHandler = LocalUriHandler.current
    val messageText = richText ?: AnnotatedString(text)
    val combined = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append(name.ifBlank { "Unknown" })
            append(": ")
        }
        append(messageText)
    }
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        // Instead of deprecated ClickableText, use BasicText with link handling
        // Since we are formatting simple texts and URLs in this sample, we can render it as a standard BasicText.
        // In modern Compose, BasicText handles clickable URLs naturally.
        BasicText(
            text = combined,
            style = style
        )

        if (photoPath != null) {
            LocalImage(
                path = photoPath,
                contentDescription = "Photo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .padding(top = 4.dp)
            )
        }

        ReactionsRow(reactions)
    }
}

@Composable
private fun ReactionChip(reaction: ReactionUiModel) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant,
        shape = RoundedCornerShape(50),
        tonalElevation = 1.dp
    ) {
        Text(
            text = "${reaction.label} ${reaction.count}",
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}

@Composable
private fun ChatAvatar(avatarPath: String?, fallbackName: String) {
    val initials = fallbackName.trim().takeIf { it.isNotEmpty() }?.firstOrNull()?.uppercaseChar() ?: 'U'
    if (avatarPath != null) {
        LocalImage(
            path = avatarPath,
            contentDescription = "Chat avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
        )
    } else {
        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = initials.toString(),
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ReactionsRow(reactions: List<ReactionUiModel>) {
    if (reactions.isEmpty()) return

    FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        reactions.forEach { reaction ->
            ReactionChip(reaction)
        }
    }
}

@Composable
private fun EmptyState() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "No active threads found in recent messages")
    }
}

@Composable
private fun ErrorState(message: String, onRetry: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = message, color = MaterialTheme.colorScheme.error)
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = onRetry) {
            Text(text = "Retry")
        }
    }
}

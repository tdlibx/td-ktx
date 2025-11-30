package com.telegramflow.example.domain.threads

import com.telegramflow.example.data.repo.TelegramRepository
import io.mockk.any
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import kotlinx.coroutines.test.runTest
import org.drinkless.tdlib.TdApi
import org.junit.Before
import org.junit.Test

class BuildThreadsForChatUseCaseTest {
    private lateinit var repository: TelegramRepository
    private lateinit var useCase: BuildThreadsForChatUseCase

    @Before
    fun setUp() {
        repository = mockk(relaxed = true)
        useCase = BuildThreadsForChatUseCase(repository)
    }

    @Test
    fun `builds rooted threads without duplicating reply-only messages`() = runTest {
        val chat = mockk<TdApi.Chat> {
            every { id } returns 10L
            every { title } returns "Group"
        }

        val root = messageMock(id = 1L, chatId = 10L, senderName = "Alice")
        val reply1 = messageMock(id = 2L, chatId = 10L, senderName = "Bob", replyTo = 1L)
        val reply2 = messageMock(id = 3L, chatId = 10L, senderName = "Carol", replyTo = 1L)

        val firstPage = messagesMock(root, reply1, reply2)
        val emptyPage = messagesMock()
        coEvery {
            repository.fetchChatHistory(chatId = 10L, fromMessageId = any(), offset = 0, limit = 100, onlyLocal = false)
        } returnsMany listOf(firstPage, emptyPage)

        coEvery { repository.fetchUser(any<Long>()) } returns userMock("Resolved")

        val threads = useCase(chat)

        assertEquals(1, threads.size)
        val thread = threads.first()
        assertEquals(root.id, thread.id)
        assertEquals(2, thread.replyCount)
        assertEquals(2, thread.replies.size)
        assertTrue(thread.replies.none { it.id == thread.id })
    }

    @Test
    fun `skips roots that appear as replies`() = runTest {
        val chat = mockk<TdApi.Chat> {
            every { id } returns 20L
            every { title } returns "Group"
        }

        val root = messageMock(id = 5L, chatId = 20L, senderName = "Root")
        val child = messageMock(id = 6L, chatId = 20L, senderName = "Child", replyTo = 5L)
        val nestedRootCandidate = messageMock(id = 7L, chatId = 20L, senderName = "Nested", replyTo = 6L)

        val firstPage = messagesMock(root, child, nestedRootCandidate)
        val emptyPage = messagesMock()
        coEvery {
            repository.fetchChatHistory(chatId = 20L, fromMessageId = any(), offset = 0, limit = 100, onlyLocal = false)
        } returnsMany listOf(firstPage, emptyPage)

        coEvery { repository.fetchUser(any<Long>()) } returns userMock("Resolved")

        val threads = useCase(chat)

        assertEquals(1, threads.size)
        val thread = threads.first()
        assertEquals(root.id, thread.id)
        assertEquals(2, thread.replyCount)
    }

    private fun messageMock(
        id: Long,
        chatId: Long,
        senderName: String,
        replyTo: Long? = null,
    ): TdApi.Message {
        val replyToMessage = replyTo?.let { parentId ->
            mockk<TdApi.MessageReplyToMessage> {
                every { messageId } returns parentId
            } as TdApi.MessageReplyTo
        }
        return mockk(relaxed = true) {
            every { this@mockk.id } returns id
            every { this@mockk.chatId } returns chatId
            every { this@mockk.date } returns id.toInt()
            every { senderId } returns mockk<TdApi.MessageSenderUser> { every { userId } returns id }
            every { this@mockk.replyTo } returns replyToMessage
            every { content } returns mockk<TdApi.MessageText> {
                every { text } returns TdApi.FormattedText("$senderName body", null)
            }
        }
    }

    private fun messagesMock(vararg messages: TdApi.Message): TdApi.Messages {
        return mockk(relaxed = true) {
            every { this@mockk.messages } returns messages
        }
    }

    private fun userMock(name: String): TdApi.User {
        return mockk(relaxed = true) {
            every { firstName } returns name
            every { lastName } returns ""
            every { usernames } returns null
        }
    }
}

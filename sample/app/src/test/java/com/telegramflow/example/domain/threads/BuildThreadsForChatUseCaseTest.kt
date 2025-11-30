package com.telegramflow.example.domain.threads

import com.telegramflow.example.data.repo.TelegramRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlin.test.assertEquals
import kotlin.test.assertTrue
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
    fun `builds rooted thread with nested replies and sender names`() = runTest {
        val chat = chat(id = 99, title = "Test Group")

        val root = message(
            id = 1,
            chatId = chat.id,
            senderId = TdApi.MessageSenderUser(10),
            text = "Root",
        )
        val reply = message(
            id = 2,
            chatId = chat.id,
            senderId = TdApi.MessageSenderUser(11),
            text = "Reply",
            replyTo = TdApi.MessageReplyToMessage(chat.id, root.id),
        )
        val nested = message(
            id = 3,
            chatId = chat.id,
            senderId = TdApi.MessageSenderUser(12),
            text = "Nested",
            replyTo = TdApi.MessageReplyToMessage(chat.id, reply.id),
        )

        coEvery {
            repository.fetchChatHistory(chat.id, any(), offset = 0, limit = any(), onlyLocal = any())
        } returns TdApi.Messages(arrayOf(root, reply, nested)) andThen TdApi.Messages(emptyArray())

        coEvery { repository.fetchUser(10) } returns user("Alice")
        coEvery { repository.fetchUser(11) } returns user("Bob")
        coEvery { repository.fetchUser(12) } returns user("Carol")

        val threads = useCase(chat)

        assertEquals(1, threads.size)
        val thread = threads.first()
        assertEquals("Alice", thread.senderName)
        assertEquals(2, thread.replies.size)
        assertTrue(thread.replies.any { it.senderName == "Bob" && it.text == "Reply" })
        assertTrue(thread.replies.any { it.senderName == "Carol" && it.text == "Nested" })
    }

    @Test
    fun `resolves photo path through repository`() = runTest {
        val chat = chat(id = 42, title = "Photos")
        val photoFile = TdApi.File(5, 0, null, 0, 0, 0, null, null, null, TdApi.LocalFile("/tmp/photo.jpg", true, true, true, 0))
        val photo = TdApi.MessagePhoto(
            TdApi.Photo(arrayOf(TdApi.PhotoSize("orig", photoFile, photoFile, 0, 0, 0)), 0, 0),
            TdApi.FormattedText("Photo text", emptyArray()),
            false,
            false,
            0,
            null,
        )

        val root = message(
            id = 1,
            chatId = chat.id,
            senderId = TdApi.MessageSenderUser(10),
            text = "Photo",
            content = photo,
        )
        val reply = message(
            id = 2,
            chatId = chat.id,
            senderId = TdApi.MessageSenderUser(11),
            text = "Reply",
            replyTo = TdApi.MessageReplyToMessage(chat.id, root.id),
        )

        coEvery {
            repository.fetchChatHistory(chat.id, any(), offset = 0, limit = any(), onlyLocal = any())
        } returns TdApi.Messages(arrayOf(root, reply)) andThen TdApi.Messages(emptyArray())

        val downloaded = TdApi.File(5, 0, null, 0, 0, 0, null, null, null, TdApi.LocalFile("/tmp/photo.jpg", true, true, true, 0))
        coEvery { repository.downloadFile(fileId = photoFile.id, priority = any(), offset = any(), limit = any(), synchronous = any()) } returns downloaded

        coEvery { repository.fetchUser(any()) } returns user("Alice")

        val threads = useCase(chat)

        assertEquals(1, threads.size)
        assertEquals("/tmp/photo.jpg", threads.first().photoPath)
    }

    private fun chat(id: Long, title: String): TdApi.Chat {
        return TdApi.Chat(
            id,
            TdApi.ChatTypeBasicGroup(1),
            title,
            null,
            0,
            0,
            null,
            null,
            null,
            null,
            false,
            false,
            false,
            false,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        )
    }

    private fun user(name: String): TdApi.User {
        return TdApi.User(
            0,
            0,
            name,
            "",
            "",
            null,
            null,
            null,
            false,
            false,
            "",
            null,
            0,
            null,
            null,
            null,
            false,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            false,
            false,
            false,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
        )
    }

    private fun message(
        id: Long,
        chatId: Long,
        senderId: TdApi.MessageSender,
        text: String,
        replyTo: TdApi.MessageReplyToMessage? = null,
        content: TdApi.MessageContent = TdApi.MessageText(TdApi.FormattedText(text, emptyArray())),
    ): TdApi.Message {
        return TdApi.Message(
            id,
            chatId,
            senderId,
            0,
            0,
            0,
            false,
            0,
            0,
            null,
            replyTo,
            false,
            null,
            null,
            content,
            0,
            0,
            null,
            null,
            null,
            false,
            false,
            null,
            0,
            0,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            false,
            null,
            null
        )
    }
}

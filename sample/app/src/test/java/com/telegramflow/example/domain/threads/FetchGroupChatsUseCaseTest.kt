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

class FetchGroupChatsUseCaseTest {
    private lateinit var repository: TelegramRepository
    private lateinit var useCase: FetchGroupChatsUseCase

    @Before
    fun setUp() {
        repository = mockk(relaxed = true)
        useCase = FetchGroupChatsUseCase(repository)
    }

    @Test
    fun `returns only non-channel group chats`() = runTest {
        val chatIds = longArrayOf(1L, 2L, 3L, 4L)
        coEvery { repository.fetchChats(chatList = null, limit = any()) } returns TdApi.Chats(chatIds)

        coEvery { repository.fetchChat(1L) } returns chat(title = "Group", type = TdApi.ChatTypeBasicGroup(1))
        coEvery { repository.fetchChat(2L) } returns chat(title = "Supergroup", type = TdApi.ChatTypeSupergroup(2, false, 0))
        coEvery { repository.fetchChat(3L) } returns chat(title = "Channel", type = TdApi.ChatTypeSupergroup(3, true, 0))
        coEvery { repository.fetchChat(4L) } returns chat(title = "Private", type = TdApi.ChatTypePrivate())

        val result = useCase()

        assertEquals(2, result.size)
        assertTrue(result.all { it.title == "Group" || it.title == "Supergroup" })
    }

    private fun chat(title: String, type: TdApi.ChatType): TdApi.Chat {
        return TdApi.Chat(
            0,
            type,
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
}

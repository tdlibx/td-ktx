package com.telegramflow.example.domain.threads

import com.telegramflow.example.data.repo.TelegramRepository
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
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
        val chatsResponse = mockk<TdApi.Chats> {
            every { totalCount } returns chatIds.size
            every { chatIds } returns chatIds
        }
        coEvery { repository.fetchChats(chatList = null, limit = 100) } returns chatsResponse

        coEvery { repository.fetchChat(1L) } returns chatMock(title = "Group", type = mockk<TdApi.ChatTypeBasicGroup>())
        coEvery { repository.fetchChat(2L) } returns chatMock(title = "Supergroup", type = mockk<TdApi.ChatTypeSupergroup> {
            every { isChannel } returns false
        })
        coEvery { repository.fetchChat(3L) } returns chatMock(title = "Channel", type = mockk<TdApi.ChatTypeSupergroup> {
            every { isChannel } returns true
        })
        coEvery { repository.fetchChat(4L) } returns chatMock(title = "Private", type = mockk<TdApi.ChatTypePrivate>())

        val result = useCase()

        assertEquals(2, result.size)
        assertTrue(result.all { it.title == "Group" || it.title == "Supergroup" })
    }

    private fun chatMock(title: String, type: TdApi.ChatType): TdApi.Chat {
        return mockk(relaxed = true) {
            every { this@mockk.title } returns title
            every { this@mockk.type } returns type
        }
    }
}

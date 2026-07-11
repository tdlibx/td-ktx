package com.telegramflow.example.ui.screen.users

import com.telegramflow.example.data.repo.TelegramRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.drinkless.tdlib.generated.UserStatusOnline

class UsersPresenter(
    private val telegramRepository: TelegramRepository,
    private val coroutineScope: CoroutineScope
) {
    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users = _users.asStateFlow()

    init {
        coroutineScope.launch {
            telegramRepository.userOnlineFlow.collectLatest { tUser ->
                _users.update { currentUsers ->
                    val updatedUser = User(
                        id = tUser.id,
                        firstName = tUser.firstName.orEmpty(),
                        lastName = tUser.lastName.orEmpty(),
                        online = tUser.status is UserStatusOnline,
                    )

                    val filtered = currentUsers.filterNot { user -> user.id == updatedUser.id }
                    (filtered + updatedUser).sortedBy { user -> user.firstName }
                }
            }
        }
    }
}

data class User(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val online: Boolean,
)

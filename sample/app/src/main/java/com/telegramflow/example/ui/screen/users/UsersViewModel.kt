package com.telegramflow.example.ui.screen.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.telegramflow.example.data.repo.TelegramRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.drinkless.tdlib.TdApi
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val telegramRepository: TelegramRepository,
) : ViewModel() {

    val users: MutableStateFlow<List<User>> = MutableStateFlow(emptyList())

    init {
        viewModelScope.launch {
            telegramRepository.userOnlineFlow.collectLatest {
                users.update { currentUsers ->
                    val updatedUser = User(
                        id = it.id,
                        firstName = it.firstName,
                        lastName = it.lastName,
                        online = it.status is TdApi.UserStatusOnline,
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
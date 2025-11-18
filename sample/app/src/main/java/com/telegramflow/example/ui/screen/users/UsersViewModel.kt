package com.telegramflow.example.ui.screen.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.telegramflow.example.data.repo.TelegramRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.drinkless.tdlib.TdApi
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor() : ViewModel() {

    val users: MutableStateFlow<List<User>> = MutableStateFlow(emptyList())

    init {
        viewModelScope.launch {
            TelegramRepository.userOnlineFlow.collectLatest {
                users.emit(
                    users.value +
                            User(
                                it.firstName,
                                it.lastName,
                                it.status is TdApi.UserStatusOnline
                            )
                )
            }
        }
    }
}

data class User(
    val firstName: String,
    val lastName: String,
    val online: Boolean,
)
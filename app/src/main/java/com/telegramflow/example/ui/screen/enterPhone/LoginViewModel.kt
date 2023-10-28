package com.telegramflow.example.ui.screen.enterPhone

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.telegramflow.example.data.repo.TelegramRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    init {
        viewModelScope.launch {
            delay(300)
            TelegramRepository.api.attachClient()
        }
    }

    val authState = TelegramRepository.authFlow

    fun phoneEntered(phoneNumber: String) {
        viewModelScope.launch {
            TelegramRepository.sendPhone(phoneNumber)
        }
    }

    fun codeEntered(code: String) {
        viewModelScope.launch {
            TelegramRepository.sendCode(code)
        }
    }

    fun passwordEntered(password: String) {
        viewModelScope.launch {
            TelegramRepository.sendPassword(password)
        }
    }
}
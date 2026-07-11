package com.telegramflow.example.ui.screen.enterPhone

import com.telegramflow.example.data.repo.TelegramRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginPresenter(
    private val telegramRepository: TelegramRepository,
    private val coroutineScope: CoroutineScope
) {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    val authState = telegramRepository.authFlow

    fun phoneEntered(phoneNumber: String) {
        launchWithLoading {
            telegramRepository.sendPhone(phoneNumber)
        }
    }

    fun codeEntered(code: String) {
        launchWithLoading {
            telegramRepository.sendCode(code)
        }
    }

    fun passwordEntered(password: String) {
        launchWithLoading {
            telegramRepository.sendPassword(password)
        }
    }

    private fun launchWithLoading(action: suspend () -> Unit) {
        coroutineScope.launch {
            if (_isLoading.value) return@launch

            _isLoading.value = true
            try {
                action()
            } finally {
                _isLoading.value = false
            }
        }
    }
}
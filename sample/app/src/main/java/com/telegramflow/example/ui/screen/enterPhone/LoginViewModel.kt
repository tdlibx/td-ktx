package com.telegramflow.example.ui.screen.enterPhone

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.telegramflow.example.data.repo.TelegramRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init {
        viewModelScope.launch {
            delay(300)
            TelegramRepository.api.attachClient()
        }
    }

    val authState = TelegramRepository.authFlow

    fun phoneEntered(phoneNumber: String) {
        launchWithLoading {
            TelegramRepository.sendPhone(phoneNumber)
        }
    }

    fun codeEntered(code: String) {
        launchWithLoading {
            TelegramRepository.sendCode(code)
        }
    }

    fun passwordEntered(password: String) {
        launchWithLoading {
            TelegramRepository.sendPassword(password)
        }
    }

    private fun launchWithLoading(action: suspend () -> Unit) {
        viewModelScope.launch {
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
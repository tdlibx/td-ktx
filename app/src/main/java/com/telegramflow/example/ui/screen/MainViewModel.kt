package com.telegramflow.example.ui.screen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    fun inputPhone(phoneNumber: String) {
//        TelegramRepository.sendPhone(phoneNumber)
    }
}
package com.github.tdlibx.example

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus

class MainViewModel : ViewModel() {

    val error = MutableLiveData<String>()

    val authState = TelegramRepository.flow.asLiveData()

    init {
        TelegramRepository.createClient()
    }

    private val scope = viewModelScope + CoroutineExceptionHandler { _, throwable ->
        error.postValue(throwable.message)
    }

    fun sendPhone(phone: String) = scope.launch {
        TelegramRepository.sendPhone(phone)
    }

    fun sendCode(code: String) = scope.launch {
        TelegramRepository.sendCode(code)
    }

    fun sendPassword(passsord: String) = scope.launch {
        TelegramRepository.sendPassword(passsord)
    }
}
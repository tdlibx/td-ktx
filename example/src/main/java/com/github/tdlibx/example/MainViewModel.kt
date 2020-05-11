package com.github.tdlibx.example

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

class MainViewModel : ViewModel() {

    val error = MutableLiveData<String>()

    val authState = TelegramRepository.flow.asLiveData()

    val newMessage = TelegramRepository.textMessagesFlow.asLiveList()

    init {
        TelegramRepository.createClient()
    }


    fun <T> Flow<T>.asLiveList(
        context: CoroutineContext = EmptyCoroutineContext,
        timeoutInMs: Long = 5000L
    ): LiveData<List<T>> = liveData(context, timeoutInMs) {
        val arrayList = ArrayList<T>()
        collect { newItem ->
            arrayList.add(newItem)
            emit(
                arrayList.toList()
            )
        }
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
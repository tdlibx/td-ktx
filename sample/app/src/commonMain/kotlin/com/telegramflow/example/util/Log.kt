package com.telegramflow.example.util

object Log {
    fun d(tag: String, message: String) {
        println("[$tag] D: $message")
    }

    fun e(tag: String, message: String, throwable: Throwable? = null) {
        println("[$tag] E: $message")
        throwable?.printStackTrace()
    }
}

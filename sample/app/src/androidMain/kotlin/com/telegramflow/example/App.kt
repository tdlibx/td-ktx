package com.telegramflow.example

import android.app.Application
import androidx.compose.foundation.ComposeFoundationFlags
import androidx.compose.foundation.ExperimentalFoundationApi
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate() {
        super.onCreate()
        @Suppress("DEPRECATION")
        ComposeFoundationFlags.isNonComposedClickableEnabled = true
    }
}

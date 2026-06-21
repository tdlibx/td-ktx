package com.telegramflow.example

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.telegram.core.TelegramFlow

/**
 * Platform-agnostic demo that demonstrates TelegramFlow usage.
 * Called from platform-specific entry points (macOS/iOS main, Android Application).
 */
object TelegramFlowDemo {

    /**
     * Attach a TelegramFlow client and observe the auth state briefly,
     * then cancel the scope. This is a demonstration of the multiplatform API surface.
     */
    fun run(appId: Int, appHash: String, onLog: (String) -> Unit) {
        val scope = CoroutineScope(Dispatchers.Default)
        val api = TelegramFlow()

        scope.launch {
            try {
                onLog("[TelegramFlowDemo] Attaching client...")
                api.attachClient()
                onLog("[TelegramFlowDemo] Client attached successfully.")
            } catch (e: Exception) {
                onLog("[TelegramFlowDemo] Error: ${e.message}")
            } finally {
                scope.cancel()
            }
        }
    }
}

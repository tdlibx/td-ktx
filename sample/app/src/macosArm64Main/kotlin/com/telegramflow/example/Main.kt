package com.telegramflow.example

import kotlinx.coroutines.runBlocking
import platform.posix.getenv
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.toKString

/**
 * macOS console entry point.
 * Demonstrates TelegramFlow client usage on macOS (Arm64).
 *
 * To run:
 *   ./gradlew :sample:app:runDebugExecutableMacosArm64
 *
 * Set env vars before running:
 *   TELEGRAM_APP_ID=12345 TELEGRAM_APP_HASH=abc123 ./build/bin/macosArm64/debugExecutable/sample-app.kexe
 */
@OptIn(ExperimentalForeignApi::class)
fun main() {
    println("=== TelegramFlow KMP Demo – macOS Arm64 ===")

    val appId = getenv("TELEGRAM_APP_ID")?.toKString()?.toIntOrNull() ?: 0
    val appHash = getenv("TELEGRAM_APP_HASH")?.toKString() ?: ""

    if (appId == 0 || appHash.isEmpty()) {
        println("[WARN] TELEGRAM_APP_ID / TELEGRAM_APP_HASH not set. Running in no-op mode.")
    }

    runBlocking {
        TelegramFlowDemo.run(appId, appHash) { message ->
            println(message)
        }
    }

    println("=== Demo finished ===")
}

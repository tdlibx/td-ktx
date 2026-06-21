package com.telegramflow.example

import kotlinx.coroutines.runBlocking
import platform.Foundation.NSProcessInfo

/**
 * iOS Simulator Arm64 console entry point.
 * Demonstrates TelegramFlow client usage on iOS Simulator.
 *
 * To run:
 *   ./gradlew :sample:app:runDebugExecutableIosSimulatorArm64
 */
fun main() {
    println("=== TelegramFlow KMP Demo – iOS Simulator Arm64 ===")

    // Read from process info environment (set via Xcode scheme)
    val env = NSProcessInfo.processInfo.environment
    val appId = (env["TELEGRAM_APP_ID"] as? String)?.toIntOrNull() ?: 0
    val appHash = (env["TELEGRAM_APP_HASH"] as? String) ?: ""

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

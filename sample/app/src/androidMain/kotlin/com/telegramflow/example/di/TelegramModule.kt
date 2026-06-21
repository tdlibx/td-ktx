package com.telegramflow.example.di

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.telegram.core.TelegramFlow
import org.drinkless.tdlib.TdLibInitResult
import org.drinkless.tdlib.TdLibInitializer

@Module
@InstallIn(SingletonComponent::class)
object TelegramModule {

    @Provides
    @Singleton
    fun provideTelegramFlow(): TelegramFlow {
        return when (val initResult = TdLibInitializer.init()) {
            is TdLibInitResult.Success -> TelegramFlow()
            is TdLibInitResult.Error -> {
                // Log the full cause so it's visible in Logcat without crashing the app
                Log.e(
                    "TelegramModule",
                    "TDLib native library failed to load. " +
                    "Ensure libtdjson_jni.so (JNI bridge) is compiled and packaged " +
                    "alongside libtdjson.so. See README for NDK setup instructions.\n" +
                    "Cause: ${initResult.message}",
                    initResult.cause
                )
                // Re-throw so Hilt surfaces a clear error rather than an NPE later
                throw IllegalStateException(
                    "TDLib JNI bridge missing: ${initResult.message}. " +
                    "Run `./gradlew :libtd:buildCMakeDebug` after installing the NDK.",
                    initResult.cause
                )
            }
        }
    }
}

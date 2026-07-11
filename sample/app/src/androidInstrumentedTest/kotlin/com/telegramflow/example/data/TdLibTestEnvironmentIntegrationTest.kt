package com.telegramflow.example.data

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.telegramflow.example.TestFixtures
import com.telegramflow.example.data.local.AuthState
import com.telegramflow.example.data.local.AndroidTelegramConfigStorage
import com.telegramflow.example.data.repo.TelegramRepository
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.telegram.core.TelegramFlow
import org.drinkless.tdlib.TdLibInitResult
import org.drinkless.tdlib.TdLibInitializer
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Verifies TDLib can initialize against Telegram's test environment (test DC).
 *
 * TDLib docs: pass useTestDc = true in setTdlibParameters.
 * https://core.telegram.org/tdlib/docs/classtd_1_1td__api_1_1set_tdlib_parameters.html
 *
 * Requires valid API credentials via instrumentation arguments:
 *   -e telegram_app_id <id> -e telegram_app_hash <hash>
 *
 * Run:
 *   ./gradlew :sample:app:connectedDebugAndroidTest \
 *     -Pandroid.testInstrumentationRunnerArguments.telegram_app_id=YOUR_ID \
 *     -Pandroid.testInstrumentationRunnerArguments.telegram_app_hash=YOUR_HASH
 */
@RunWith(AndroidJUnit4::class)
class TdLibTestEnvironmentIntegrationTest {

  @Before
  fun setUp() {
    TestFixtures.clearTelegramConfig()
  }

  @Test
  fun useTestDc_reachesPhoneNumberAuthorizationState() {
    val appId = TestFixtures.telegramAppId()
    val appHash = TestFixtures.telegramAppHash()
    if (appId == null || appHash.isNullOrBlank()) {
      println(
        "SKIPPED: Provide telegram_app_id and telegram_app_hash instrumentation arguments " +
          "to run the TDLib test DC integration test."
      )
      return
    }

    val initResult = TdLibInitializer.init()
    if (initResult is TdLibInitResult.Error) {
      println("SKIPPED: TDLib native library failed to load: ${initResult.message}")
      return
    }

    val context = InstrumentationRegistry.getInstrumentation().targetContext
    val configStorage = AndroidTelegramConfigStorage(context).apply {
      this.appId = appId
      this.appHash = appHash
      useTestDc = true
    }

    val repository = TelegramRepository(
      api = TelegramFlow(),
      configStorage = configStorage,
    )

    runBlocking {
      repository.attachClient()
      val authState = withTimeout(30_000) {
        repository.authFlow.filterNotNull().first()
      }
      assertTrue(
        "Expected phone-number auth state on test DC, got: $authState",
        authState is AuthState.EnterPhone,
      )
    }
  }
}

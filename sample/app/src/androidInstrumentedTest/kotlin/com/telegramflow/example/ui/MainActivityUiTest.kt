package com.telegramflow.example.ui

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.telegramflow.example.TestFixtures
import com.telegramflow.example.data.local.TelegramConfigStorage
import com.telegramflow.example.ui.screen.MainActivity
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@OptIn(ExperimentalComposeUiApi::class)
class MainActivityUiTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        TestFixtures.clearTelegramConfig()
    }

    @Test
    fun mainActivity_showsConfigScreenWhenNotConfigured() {
        composeRule.onNodeWithTag("config_screen_title").assertIsDisplayed()
        composeRule.onNodeWithText("App ID").assertIsDisplayed()
        composeRule.onNodeWithText("App Hash").assertIsDisplayed()
    }

    @Test
    fun mainActivity_saveConfigNavigatesToLoginScreen() {
        composeRule.onNodeWithText("App ID").performTextInput("12345")
        composeRule.onNodeWithText("App Hash").performTextInput("test_hash_value")
        composeRule.onNodeWithTag("config_save_button").performClick()

        composeRule.waitForIdle()

        composeRule.onNodeWithText(
            "Welcome to the Telegram Flow example. Start by entering your phone number."
        ).assertIsDisplayed()
        composeRule.onNodeWithTag("login_continue_button").assertIsDisplayed()

        val configStorage = TelegramConfigStorage(TestFixtures.targetContext())
        assertTrue(configStorage.isConfigured)
        assertEquals(12345, configStorage.appId)
        assertEquals("test_hash_value", configStorage.appHash)
    }
}

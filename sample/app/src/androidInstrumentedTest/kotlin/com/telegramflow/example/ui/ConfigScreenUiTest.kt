package com.telegramflow.example.ui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.telegramflow.example.TestFixtures
import com.telegramflow.example.data.local.AndroidTelegramConfigStorage
import com.telegramflow.example.data.local.TelegramConfigStorage
import com.telegramflow.example.ui.screen.config.ConfigScreen
import com.telegramflow.example.ui.theme.TelegramFlowComposeTheme
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ConfigScreenUiTest {

    @get:Rule
    val composeRule = createComposeRule()

    private lateinit var configStorage: TelegramConfigStorage
    private var configSaved = false

    @Before
    fun setUp() {
        TestFixtures.clearTelegramConfig()
        configStorage = AndroidTelegramConfigStorage(TestFixtures.targetContext())
        configSaved = false
    }

    @Test
    fun configScreen_displaysRequiredFields() {
        showConfigScreen()

        composeRule.onNodeWithTag("config_screen_title").assertIsDisplayed()
        composeRule.onNodeWithText("App ID").assertIsDisplayed()
        composeRule.onNodeWithText("App Hash").assertIsDisplayed()
        composeRule.onNodeWithTag("config_use_test_dc").assertIsDisplayed()
        composeRule.onNodeWithTag("config_save_button").assertIsDisplayed()
    }

    @Test
    fun configScreen_savePersistsCredentialsAndTestDcFlag() {
        showConfigScreen()

        composeRule.onNodeWithText("App ID").performTextInput("12345")
        composeRule.onNodeWithText("App Hash").performTextInput("test_hash_value")
        composeRule.onNodeWithTag("config_use_test_dc").performClick()
        composeRule.onNodeWithTag("config_save_button").assertIsEnabled().performClick()

        composeRule.waitForIdle()

        assertTrue(configSaved)
        assertEquals(12345, configStorage.appId)
        assertEquals("test_hash_value", configStorage.appHash)
        assertTrue(configStorage.useTestDc)
    }

    private fun showConfigScreen() {
        composeRule.setContent {
            TelegramFlowComposeTheme {
                ConfigScreen(
                    configStorage = configStorage,
                    onConfigSaved = { configSaved = true },
                )
            }
        }
    }
}

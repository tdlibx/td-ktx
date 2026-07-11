package com.telegramflow.example.ui

import androidx.compose.material.Text
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.telegramflow.example.ui.screen.MainScreen
import com.telegramflow.example.ui.theme.TelegramFlowComposeTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainScreenUiTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun mainScreen_switchesBetweenTabs() {
        composeRule.setContent {
            TelegramFlowComposeTheme {
                MainScreen(
                    userOnlineContent = { Text("User Online Content") },
                    threadsContent = { Text("Threads Content") },
                )
            }
        }

        composeRule.onNodeWithTag("main_tab_user_online").assertIsDisplayed()
        composeRule.onNodeWithTag("main_tab_threads").assertIsDisplayed()
        composeRule.onNodeWithText("User Online Content").assertIsDisplayed()

        composeRule.onNodeWithTag("main_tab_threads").performClick()
        composeRule.onNodeWithText("Threads Content").assertIsDisplayed()

        composeRule.onNodeWithTag("main_tab_user_online").performClick()
        composeRule.onNodeWithText("User Online Content").assertIsDisplayed()
    }
}

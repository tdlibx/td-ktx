package com.telegramflow.example.ui

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.telegramflow.example.data.local.AuthState
import com.telegramflow.example.ui.screen.enterPhone.LoginScreen
import com.telegramflow.example.ui.theme.TelegramFlowComposeTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginScreenUiTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun loginScreen_showsWelcomeHintWhenAuthStateUnknown() {
        composeRule.setContent {
            TelegramFlowComposeTheme {
                LoginScreen(
                    phoneNumber = "",
                    password = "",
                    code = "",
                    onPhoneNumberChanged = {},
                    onCodeChanged = {},
                    onPasswordChanged = {},
                    onNextClicked = {},
                )
            }
        }

        composeRule.onNodeWithText(
            "Welcome to the Telegram Flow example. Start by entering your phone number."
        ).assertIsDisplayed()
    }

    @Test
    fun loginScreen_enterPhoneStateShowsPhoneFieldAndDisabledContinue() {
        composeRule.setContent {
            TelegramFlowComposeTheme {
                LoginScreen(
                    phoneNumber = "",
                    password = "",
                    code = "",
                    onPhoneNumberChanged = {},
                    onCodeChanged = {},
                    onPasswordChanged = {},
                    onNextClicked = {},
                    authState = remember { mutableStateOf(AuthState.EnterPhone) },
                    loadingState = remember { mutableStateOf(false) },
                )
            }
        }

        composeRule.onNodeWithText("Enter phone").assertIsDisplayed()
        composeRule.onNodeWithTag("login_continue_button").assertIsNotEnabled()
    }

    @Test
    fun loginScreen_enterPhoneStateEnablesContinueWhenPhoneEntered() {
        composeRule.setContent {
            TelegramFlowComposeTheme {
                LoginScreen(
                    phoneNumber = "9996621234",
                    password = "",
                    code = "",
                    onPhoneNumberChanged = {},
                    onCodeChanged = {},
                    onPasswordChanged = {},
                    onNextClicked = {},
                    authState = remember { mutableStateOf(AuthState.EnterPhone) },
                    loadingState = remember { mutableStateOf(false) },
                )
            }
        }

        composeRule.onNodeWithTag("login_continue_button").assertIsDisplayed()
    }

    @Test
    fun loginScreen_enterCodeStateShowsCodeField() {
        composeRule.setContent {
            TelegramFlowComposeTheme {
                LoginScreen(
                    phoneNumber = "",
                    password = "",
                    code = "",
                    onPhoneNumberChanged = {},
                    onCodeChanged = {},
                    onPasswordChanged = {},
                    onNextClicked = {},
                    authState = remember { mutableStateOf(AuthState.EnterCode) },
                    loadingState = remember { mutableStateOf(false) },
                )
            }
        }

        composeRule.onNodeWithText("Enter code").assertIsDisplayed()
    }
}

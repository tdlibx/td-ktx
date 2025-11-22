@file:OptIn(ExperimentalComposeUiApi::class)

package com.telegramflow.example.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.telegramflow.example.ui.screen.enterPhone.LoginScreen
import com.telegramflow.example.ui.screen.users.UsersScreen
import com.telegramflow.example.ui.theme.TelegramFlowComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TelegramFlowComposeTheme {
                Surface {
                    AppNavigation()
                }
            }
        }
    }

    @Preview
    @Composable
    private fun AppNavigation() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Screen.Dashboard.route) {

            // Splash
            composable(Screen.Users.route) {
                UsersScreen()
            }

            // Dashboard
            composable(Screen.Dashboard.route) {
                var phoneNumber by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }
                var code by remember { mutableStateOf("") }
                LoginScreen(
                    phoneNumber = phoneNumber,
                    password = password,
                    code = code,
                    onPhoneNumberChanged = { phoneNumber = it },
                    onCodeChanged = { code = it },
                    onPasswordChanged = { password = it },
                    onNextClicked = {
                        navController.navigate(
                            Screen.Users.route,
                        ) {
                            popUpTo(Screen.Dashboard.route) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}
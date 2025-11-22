package com.telegramflow.example.ui.screen

sealed class Screen(val route: String) {
    object Users : Screen("users")
    object Login : Screen("login")
}
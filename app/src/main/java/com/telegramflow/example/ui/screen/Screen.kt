package com.telegramflow.example.ui.screen

sealed class Screen(val route: String) {
    object Users : Screen("Users")
    object Dashboard : Screen("dashboard")
}
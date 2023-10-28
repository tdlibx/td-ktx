package com.telegramflow.example.data.local

sealed class AuthState(val dialogHint: String) {
    object LoggedIn : AuthState("")
    object EnterPhone : AuthState("Enter phone")
    object EnterCode : AuthState("Enter code")
    class EnterPassword(passwordHint: String) : AuthState("Enter password. Hint: $passwordHint")
}
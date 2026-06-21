package com.telegramflow.example.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.telegramflow.example.ui.screen.threads.ThreadsScreen
import com.telegramflow.example.ui.screen.users.UsersScreen

private enum class MainTab(val title: String) {
    UserOnline("User Online"),
    Threads("Threads"),
}

@Composable
fun MainScreen() {
    var selectedTab by remember { mutableStateOf(MainTab.UserOnline) }
    val tabs = MainTab.entries

    Column(modifier = Modifier.fillMaxSize().statusBarsPadding()) {
        TabRow(selectedTabIndex = tabs.indexOf(selectedTab)) {
            tabs.forEach { tab ->
                Tab(
                    selected = tab == selectedTab,
                    onClick = { selectedTab = tab },
                    text = { Text(text = tab.title) }
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            when (selectedTab) {
                MainTab.UserOnline -> UsersScreen()
                MainTab.Threads -> ThreadsScreen()
            }
        }
    }
}

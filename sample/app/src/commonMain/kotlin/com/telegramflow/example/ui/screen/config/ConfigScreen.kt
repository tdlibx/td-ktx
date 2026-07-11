package com.telegramflow.example.ui.screen.config

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.telegramflow.example.data.local.TelegramConfigStorage

@Composable
fun ConfigScreen(
    configStorage: TelegramConfigStorage,
    onConfigSaved: () -> Unit
) {
    var appId by remember { mutableStateOf(if (configStorage.appId != 0) configStorage.appId.toString() else "") }
    var appHash by remember { mutableStateOf(configStorage.appHash ?: "") }
    var useTestDc by remember { mutableStateOf(configStorage.useTestDc) }
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Telegram API Configuration",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .testTag("config_screen_title"),
        )

        TextField(
            value = appId,
            onValueChange = { appId = it },
            label = { Text("App ID") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = appHash,
            onValueChange = { appHash = it },
            label = { Text("App Hash") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("config_use_test_dc"),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Use Test Data Center",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.weight(1f),
            )
            Switch(
                checked = useTestDc,
                onCheckedChange = { useTestDc = it },
            )
        }

        Text(
            text = "If enabled, the app will connect to Telegram's test environment.",
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(top = 4.dp),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "You can get your App ID and Hash at ",
            style = MaterialTheme.typography.body2
        )
        ClickableText(
            text = AnnotatedString("https://my.telegram.org"),
            style = TextStyle(color = Color.Blue),
            onClick = {
                uriHandler.openUri("https://my.telegram.org")
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                val id = appId.toIntOrNull()
                if (id != null && appHash.isNotBlank()) {
                    configStorage.appId = id
                    configStorage.appHash = appHash
                    configStorage.useTestDc = useTestDc
                    onConfigSaved()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .testTag("config_save_button"),
            enabled = appId.isNotBlank() && appHash.isNotBlank()
        ) {
            Text("Save and Continue")
        }
    }
}

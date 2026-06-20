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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.telegramflow.example.R

@Composable
fun ConfigScreen(
    onConfigSaved: () -> Unit,
    viewModel: ConfigViewModel = hiltViewModel()
) {
    var appId by remember { mutableStateOf("") }
    var appHash by remember { mutableStateOf("") }
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.config_title),
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        TextField(
            value = appId,
            onValueChange = { appId = it },
            label = { Text(stringResource(id = R.string.config_app_id_label)) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = appHash,
            onValueChange = { appHash = it },
            label = { Text(stringResource(id = R.string.config_app_hash_label)) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(id = R.string.config_help_text),
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
                    viewModel.saveConfig(id, appHash)
                    onConfigSaved()
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = appId.isNotBlank() && appHash.isNotBlank()
        ) {
            Text(stringResource(id = R.string.config_save_action))
        }
    }
}

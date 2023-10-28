package com.telegramflow.example.ui.screen.enterPhone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.telegramflow.example.R
import com.telegramflow.example.data.local.AuthState
import com.telegramflow.example.ui.theme.TelegramFlowComposeTheme

@Composable
fun LoginScreen(
    phoneNumber: String,
    onPhoneNumberChanged: (String) -> Unit,
    onCodeChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onNextClicked: () -> Unit,
    isLoading: Boolean,
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    viewModel: LoginViewModel = hiltViewModel(),
    password: String = remember { "" },
    code: String = remember { "" },
    authstate: State<AuthState?> = viewModel.authState.collectAsState(null)
) {

    val state: AuthState?  = authstate.value
    var isPasswordVisible: Boolean = remember { false }

    LaunchedEffect(state) {
        if (state is AuthState.LoggedIn) {
            onNextClicked()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_compose_logo),
            contentDescription = stringResource(id = R.string.cd_app_logo),
            modifier = Modifier
                .size(200.dp)
        )

        Text(text = state?.dialogHint ?: "null")
        if (state is AuthState.EnterPhone)
            TextField(
                value = phoneNumber,
                onValueChange = onPhoneNumberChanged,
                label = { state.dialogHint },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        if (state is AuthState.EnterCode)
            TextField(
                value = code,
                onValueChange = onCodeChanged,
                label = { state.dialogHint },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        if (state is AuthState.EnterPassword) {
            TextField(
                value = password,
                onValueChange = onPasswordChanged,
                label = { Text(state.dialogHint) },
                visualTransformation =
                if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            // Add a password visibility toggle button
            IconButton(
                onClick = { isPasswordVisible = !isPasswordVisible },
                modifier = Modifier.align(Alignment.End)
            ) {
                Icon(
                    imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    contentDescription = "Toggle Password Visibility"
                )
            }
        }
        if (state !is AuthState.LoggedIn)
            Button(
                onClick = {
                    when {
                        state is AuthState.EnterPhone -> viewModel.phoneEntered(phoneNumber)
                        state is AuthState.EnterCode -> viewModel.codeEntered(code)
                        state is AuthState.EnterPassword -> viewModel.passwordEntered(password)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                enabled = phoneNumber.isNotBlank() && !isLoading
            ) {
                Text("Next")
            }
        if (isLoading) {
            CircularProgressIndicator()
        }
        // Override shapes to not use the ones coming from the MdcTheme
        MaterialTheme(shapes = Shapes()) {
            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier
                    .systemBarsPadding()
                    .padding(all = 8.dp),
            ) {
                Snackbar(it)
            }
        }
    }
}

@Preview
@Composable
private fun EnterPhoneScreenPreview(
) {
    TelegramFlowComposeTheme {
        LoginScreen(
            phoneNumber = "",
            password = "password",
            code = "code",
            onPhoneNumberChanged = { },
            onCodeChanged = { },
            onPasswordChanged = { },
            onNextClicked = {},
            isLoading = false,
            authstate = remember {
                mutableStateOf(AuthState.EnterPhone)
            }
        )
    }
}

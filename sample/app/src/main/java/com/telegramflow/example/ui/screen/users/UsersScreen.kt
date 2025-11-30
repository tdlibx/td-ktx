package com.telegramflow.example.ui.screen.users

import androidx.activity.compose.ReportDrawnWhen
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.telegramflow.example.R
import com.telegramflow.example.ui.theme.TelegramFlowComposeTheme

@Composable
fun UsersScreen(
    viewModel: UsersViewModel = hiltViewModel(),
    users: State<List<User>> = viewModel.users.collectAsState()
) {
    val gridState = rememberLazyListState()
    ReportDrawnWhen { gridState.layoutInfo.totalItemsCount > 0 }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Icon(
            modifier = Modifier.size(width = 80.dp, height = 40.dp),
            painter = painterResource(id = R.drawable.ic_compose_logo),
            contentDescription = null,
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Users online",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Real-time status change",
            fontSize = 14.sp,
        )

        Spacer(modifier = Modifier.height(28.dp))

        LazyColumn(
            modifier = Modifier
                .testTag("Stream_UserLogin")
                .fillMaxWidth()
                .weight(1f),
            state = gridState
        ) {
            items(items = users.value) { userCredentials ->
                UserLoginItem(
                    modifier = Modifier.testTag("Stream_UserLoginItem"),
                    userCredentials = userCredentials,
                    onItemClick = {},
                )
            }
        }

        Text(
            modifier = Modifier.padding(16.dp),
            text = "1.0.0",
            fontSize = 14.sp,
        )
    }
}

/**
 * Represents a user to display.
 */
@Composable
fun UserLoginItem(
    modifier: Modifier,
    userCredentials: User,
    onItemClick: (User) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .clickable(
                onClick = { onItemClick(userCredentials) },
                interactionSource = remember { MutableInteractionSource() },
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Column(
            modifier = Modifier
                .wrapContentHeight()
                .weight(1f)
                .padding(horizontal = 16.dp),
        ) {
            Text(
                text = "${userCredentials.firstName} ${userCredentials.lastName}",
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = if (!userCredentials.online) "went offline" else "is online",
            )
        }
    }
}

@Preview
@Composable
private fun UsersPreview(
) {
    TelegramFlowComposeTheme {
        UsersScreen(
              users = remember {
                  mutableStateOf(
                      listOf(
                          User(
                              id = 1,
                              "John",
                              "Doe",
                              true
                          ),
                          User(
                              id = 2,
                              "John",
                              "Doe",
                              false
                          )
                      )
                )
            }
        )
    }
}
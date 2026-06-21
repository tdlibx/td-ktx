package kotlinx.telegram.flows

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.telegram.core.TelegramFlow
import org.drinkless.tdlib.generated.AuthorizationState
import org.drinkless.tdlib.generated.UpdateAuthorizationState
import org.drinkless.tdlib.generated.UpdateUserStatus

fun TelegramFlow.authorizationStateFlow(): Flow<AuthorizationState> =
    this.getUpdatesFlowOfType<UpdateAuthorizationState>()
        .mapNotNull { it.authorizationState }

fun TelegramFlow.userStatusFlow(): Flow<UpdateUserStatus> =
    this.getUpdatesFlowOfType()

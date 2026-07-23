package kotlinx.telegram.core

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.mapNotNull
import org.drinkless.tdlib.TdKtxClient
import org.drinkless.tdlib.generated.TdObject
import org.drinkless.tdlib.generated.Update
import org.drinkless.tdlib.generated.tdJson

open class TelegramFlow(
    engine: org.drinkless.tdlib.TdEngine = org.drinkless.tdlib.TdClientEngine(),
) : TdKtxClient(engine = engine) {
    val updatesFlow: Flow<Update> =
        this.updates.mapNotNull { json ->
            try {
                tdJson.decodeFromString(Update.serializer(), json)
            } catch (e: Exception) {
                null
            }
        }

    inline fun <reified T : TdObject> getUpdatesFlowOfType(): Flow<T> = updatesFlow.filterIsInstance<T>()

    fun attachClient() {
        // TdKtxClient initiates creation and listener loop in constructor.
    }
}

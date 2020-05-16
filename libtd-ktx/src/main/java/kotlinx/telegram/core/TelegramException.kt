package kotlinx.telegram.core

import org.drinkless.td.libcore.telegram.TdApi

sealed class TelegramException(message: String) : Throwable(message) {
    object ClientNotAttached :
        TelegramException(
            "Client is not attached. Please call TelegramScope.attachClient() " +
                "before calling a Telegram function"
        )

    class Error(message: String) : TelegramException(message)
    class UnexpectedResult(result: TdApi.Object) : TelegramException("unexpected result: $result")
}
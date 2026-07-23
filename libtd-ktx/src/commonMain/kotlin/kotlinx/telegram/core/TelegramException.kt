package kotlinx.telegram.core

import org.drinkless.tdlib.generated.TdObject

sealed class TelegramException(
    message: String,
) : Throwable(message) {
    object ClientNotAttached :
        TelegramException(
            "Client is not attached. Please call TelegramFlow.attachClient() " +
                "before calling a Telegram function",
        )

    class Error(
        message: String,
    ) : TelegramException(message)

    class UnexpectedResult(
        result: TdObject,
    ) : TelegramException("unexpected result: $result")
}

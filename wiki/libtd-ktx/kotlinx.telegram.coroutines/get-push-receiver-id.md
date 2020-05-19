[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getPushReceiverId](./get-push-receiver-id.md)

# getPushReceiverId

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getPushReceiverId(payload: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`PushReceiverId`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PushReceiverId.html)

Suspend function, which returns a globally unique push notification subscription identifier for
identification of an account, which has received a push notification. This is an offline method. Can
be called before authorization. Can be called synchronously.

### Parameters

`payload` - JSON-encoded push notification payload.

**Return**
[PushReceiverId](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PushReceiverId.html) Contains a globally unique push receiver identifier, which can be used
to identify which account has received a push notification.


[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [processPushNotification](./process-push-notification.md)

# processPushNotification

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.processPushNotification(payload: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which handles a push notification. Returns error with code 406 if the push
notification is not supported and connection to the server is required to fetch new data. Can be
called before authorization.

### Parameters

`payload` - JSON-encoded push notification payload with all fields sent by the server, and
&amp;quot;google.sentTime&amp;quot; and &amp;quot;google.notification.sound&amp;quot; fields added.
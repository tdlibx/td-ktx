[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [close](./close.md)

# close

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.close(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which closes the TDLib instance. All databases will be flushed to disk and
properly closed. After the close completes, updateAuthorizationState with authorizationStateClosed
will be sent.


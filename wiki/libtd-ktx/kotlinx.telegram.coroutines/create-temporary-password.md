[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [createTemporaryPassword](./create-temporary-password.md)

# createTemporaryPassword

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.createTemporaryPassword(password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, validFor: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`TemporaryPasswordState`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/TemporaryPasswordState.html)

Suspend function, which creates a new temporary password for processing payments.

### Parameters

`password` - Persistent user password.

`validFor` - Time during which the temporary password will be valid, in seconds; should be
between 60 and 86400.

**Return**
[TemporaryPasswordState](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/TemporaryPasswordState.html) Returns information about the availability of a temporary
password, which can be used for payments.


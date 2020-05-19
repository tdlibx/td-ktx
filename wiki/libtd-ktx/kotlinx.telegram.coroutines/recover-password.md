[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [recoverPassword](./recover-password.md)

# recoverPassword

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.recoverPassword(recoveryCode: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`PasswordState`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PasswordState.html)

Suspend function, which recovers the password using a recovery code sent to an email address that
was previously set up.

### Parameters

`recoveryCode` - Recovery code to check.

**Return**
[PasswordState](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PasswordState.html) Represents the current state of 2-step verification.


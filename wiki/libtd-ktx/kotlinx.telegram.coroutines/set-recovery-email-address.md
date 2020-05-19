[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [setRecoveryEmailAddress](./set-recovery-email-address.md)

# setRecoveryEmailAddress

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.setRecoveryEmailAddress(password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, newRecoveryEmailAddress: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`PasswordState`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PasswordState.html)

Suspend function, which changes the 2-step verification recovery email address of the user. If a
new recovery email address is specified, then the change will not be applied until the new recovery
email address is confirmed. If newRecoveryEmailAddress is the same as the email address that is
currently set up, this call succeeds immediately and aborts all other requests waiting for an email
confirmation.

### Parameters

`password` - Password of the current user.

`newRecoveryEmailAddress` - New recovery email address.

**Return**
[PasswordState](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PasswordState.html) Represents the current state of 2-step verification.


[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [requestPasswordRecovery](./request-password-recovery.md)

# requestPasswordRecovery

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.requestPasswordRecovery(): `[`EmailAddressAuthenticationCodeInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/EmailAddressAuthenticationCodeInfo.html)

Suspend function, which requests to send a password recovery code to an email address that was
previously set up.

**Return**
[EmailAddressAuthenticationCodeInfo](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/EmailAddressAuthenticationCodeInfo.html) Information about the email address authentication
code that was sent.


[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [resendChangePhoneNumberCode](./resend-change-phone-number-code.md)

# resendChangePhoneNumberCode

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.resendChangePhoneNumberCode(): `[`AuthenticationCodeInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.AuthenticationCodeInfo.html)

Suspend function, which re-sends the authentication code sent to confirm a new phone number for
the user. Works only if the previously received authenticationCodeInfo nextCodeType was not null.

**Return**
[AuthenticationCodeInfo](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.AuthenticationCodeInfo.html) Information about the authentication code that was sent.


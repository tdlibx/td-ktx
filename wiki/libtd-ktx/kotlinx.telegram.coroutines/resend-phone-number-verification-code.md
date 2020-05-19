[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [resendPhoneNumberVerificationCode](./resend-phone-number-verification-code.md)

# resendPhoneNumberVerificationCode

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.resendPhoneNumberVerificationCode(): `[`AuthenticationCodeInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.AuthenticationCodeInfo.html)

Suspend function, which re-sends the code to verify a phone number to be added to a user's
Telegram Passport.

**Return**
[AuthenticationCodeInfo](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.AuthenticationCodeInfo.html) Information about the authentication code that was sent.


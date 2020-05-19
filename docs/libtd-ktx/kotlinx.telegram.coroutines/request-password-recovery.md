---
title: requestPasswordRecovery - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [requestPasswordRecovery](./request-password-recovery.html)

# requestPasswordRecovery

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.requestPasswordRecovery(): `[`EmailAddressAuthenticationCodeInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/EmailAddressAuthenticationCodeInfo.html)

Suspend function, which requests to send a password recovery code to an email address that was
previously set up.

**Return**
[EmailAddressAuthenticationCodeInfo](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/EmailAddressAuthenticationCodeInfo.html) Information about the email address authentication
code that was sent.


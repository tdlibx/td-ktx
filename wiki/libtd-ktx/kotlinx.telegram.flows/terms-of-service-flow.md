[libtd-ktx](../index.md) / [kotlinx.telegram.flows](index.md) / [termsOfServiceFlow](./terms-of-service-flow.md)

# termsOfServiceFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.termsOfServiceFlow(): Flow<`[`UpdateTermsOfService`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateTermsOfService.html)`>`

emits [UpdateTermsOfService](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateTermsOfService.html) if new terms of service must be accepted by the user. If the terms
of service are declined, then the deleteAccount method should be called with the reason
&amp;quot;Decline ToS update&amp;quot;.


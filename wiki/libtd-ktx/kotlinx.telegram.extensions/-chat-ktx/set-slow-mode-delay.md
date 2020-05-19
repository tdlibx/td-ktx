[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [setSlowModeDelay](./set-slow-mode-delay.md)

# setSlowModeDelay

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.setSlowModeDelay(slowModeDelay: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the slow mode delay of a chat. Available only for supergroups;
requires canRestrictMembers rights.

### Parameters

`slowModeDelay` - New slow mode delay for the chat; must be one of 0, 10, 30, 60, 300, 900,
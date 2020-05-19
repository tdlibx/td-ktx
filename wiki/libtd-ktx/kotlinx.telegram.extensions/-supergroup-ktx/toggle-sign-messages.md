[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [SupergroupKtx](index.md) / [toggleSignMessages](./toggle-sign-messages.md)

# toggleSignMessages

`open suspend fun `[`Supergroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Supergroup.html)`.toggleSignMessages(signMessages: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which toggles sender signatures messages sent in a channel; requires
canChangeInfo rights.

### Parameters

`signMessages` - New value of signMessages.
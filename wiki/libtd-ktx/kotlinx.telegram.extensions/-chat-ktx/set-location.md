[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [setLocation](./set-location.md)

# setLocation

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.setLocation(location: `[`ChatLocation`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ChatLocation.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the location of a chat. Available only for some location-based
supergroups, use supergroupFullInfo.canSetLocation to check whether the method is allowed to use.

### Parameters

`location` - New location for the chat; must be valid and not null.
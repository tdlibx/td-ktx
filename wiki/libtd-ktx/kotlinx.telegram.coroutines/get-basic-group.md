[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getBasicGroup](./get-basic-group.md)

# getBasicGroup

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getBasicGroup(basicGroupId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`BasicGroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.BasicGroup.html)

Suspend function, which returns information about a basic group by its identifier. This is an
offline request if the current user is not a bot.

### Parameters

`basicGroupId` - Basic group identifier.

**Return**
[BasicGroup](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.BasicGroup.html) Represents a basic group of 0-200 users (must be upgraded to a supergroup to
accommodate more than 200 users).


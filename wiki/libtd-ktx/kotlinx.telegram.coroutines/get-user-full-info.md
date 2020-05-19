[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getUserFullInfo](./get-user-full-info.md)

# getUserFullInfo

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getUserFullInfo(userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`UserFullInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UserFullInfo.html)

Suspend function, which returns full information about a user by their identifier.

### Parameters

`userId` - User identifier.

**Return**
[UserFullInfo](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UserFullInfo.html) Contains full information about a user (except the full list of profile
photos).


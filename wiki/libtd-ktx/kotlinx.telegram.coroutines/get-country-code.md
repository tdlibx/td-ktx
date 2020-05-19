[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getCountryCode](./get-country-code.md)

# getCountryCode

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getCountryCode(): `[`Text`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Text.html)

Suspend function, which uses current user IP to found their country. Returns two-letter ISO
3166-1 alpha-2 country code. Can be called before authorization.

**Return**
[Text](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Text.html) Contains some text.


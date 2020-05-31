---
title: getBackgrounds - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getBackgrounds](./get-backgrounds.html)

# getBackgrounds

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getBackgrounds(forDarkTheme: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Backgrounds`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Backgrounds.html)

Suspend function, which returns backgrounds installed by the user.

### Parameters

`forDarkTheme` - True, if the backgrounds needs to be ordered for dark theme.

**Return**
[Backgrounds](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Backgrounds.html) Contains a list of backgrounds.


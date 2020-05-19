---
title: setBackground - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [setBackground](./set-background.html)

# setBackground

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.setBackground(background: `[`InputBackground`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/InputBackground.html)`?, type: `[`BackgroundType`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/BackgroundType.html)`?, forDarkTheme: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Background`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Background.html)

Suspend function, which changes the background selected by the user; adds background to the list
of installed backgrounds.

### Parameters

`background` - The input background to use, null for filled backgrounds.

`type` - Background type; null for default background. The method will return error 404 if
type is null.

`forDarkTheme` - True, if the background is chosen for dark theme.

**Return**
[Background](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Background.html) Describes a chat background.


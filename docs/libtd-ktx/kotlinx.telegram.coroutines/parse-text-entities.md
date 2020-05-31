---
title: parseTextEntities - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [parseTextEntities](./parse-text-entities.html)

# parseTextEntities

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.parseTextEntities(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, parseMode: `[`TextParseMode`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.TextParseMode.html)`?): `[`FormattedText`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.FormattedText.html)

Suspend function, which parses Bold, Italic, Underline, Strikethrough, Code, Pre, PreCode,
TextUrl and MentionName entities contained in the text. This is an offline method. Can be called
before authorization. Can be called synchronously.

### Parameters

`text` - The text which should be parsed.

`parseMode` - Text parse mode.

**Return**
[FormattedText](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.FormattedText.html) A text with some entities.


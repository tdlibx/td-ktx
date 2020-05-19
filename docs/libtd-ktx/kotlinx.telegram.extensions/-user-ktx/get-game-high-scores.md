---
title: UserKtx.getGameHighScores - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [UserKtx](index.html) / [getGameHighScores](./get-game-high-scores.html)

# getGameHighScores

`open suspend fun `[`User`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/User.html)`.getGameHighScores(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`GameHighScores`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/GameHighScores.html)

Suspend function, which returns the high scores for a game and some part of the high score
table in the range of the specified user; for bots only.

### Parameters

`chatId` - The chat that contains the message with the game.

`messageId` - Identifier of the message.

**Return**
[TdApi.GameHighScores](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/GameHighScores.html) Contains a list of game high scores.


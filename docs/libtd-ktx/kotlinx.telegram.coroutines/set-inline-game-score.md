---
title: setInlineGameScore - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [setInlineGameScore](./set-inline-game-score.html)

# setInlineGameScore

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.setInlineGameScore(inlineMessageId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, editMessage: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, score: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, force: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which updates the game score of the specified user in a game; for bots only.

### Parameters

`inlineMessageId` - Inline message identifier.

`editMessage` - True, if the message should be edited.

`userId` - User identifier.

`score` - The new score.

`force` - Pass true to update the score even if it decreases. If the score is 0, the user will
be deleted from the high score table.
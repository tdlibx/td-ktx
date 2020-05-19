[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [addSavedAnimation](./add-saved-animation.md)

# addSavedAnimation

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.addSavedAnimation(animation: `[`InputFile`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/InputFile.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which manually adds a new animation to the list of saved animations. The new
animation is added to the beginning of the list. If the animation was already in the list, it is
removed first. Only non-secret video animations with MIME type &amp;quot;video/mp4&amp;quot; can be added to
the list.

### Parameters

`animation` - The animation file to be added. Only animations known to the server (i.e.
successfully sent via a message) can be added to the list.
[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [addCustomServerLanguagePack](./add-custom-server-language-pack.md)

# addCustomServerLanguagePack

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.addCustomServerLanguagePack(languagePackId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which adds a custom server language pack to the list of installed language
packs in current localization target. Can be called before authorization.

### Parameters

`languagePackId` - Identifier of a language pack to be added; may be different from a name
that is used in an &amp;quot;https://t.me/setlanguage/&amp;quot; link.
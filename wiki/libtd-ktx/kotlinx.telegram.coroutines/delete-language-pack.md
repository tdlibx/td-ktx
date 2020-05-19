[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [deleteLanguagePack](./delete-language-pack.md)

# deleteLanguagePack

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.deleteLanguagePack(languagePackId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which deletes all information about a language pack in the current localization
target. The language pack which is currently in use (including base language pack) or is being
synchronized can't be deleted. Can be called before authorization.

### Parameters

`languagePackId` - Identifier of the language pack to delete.
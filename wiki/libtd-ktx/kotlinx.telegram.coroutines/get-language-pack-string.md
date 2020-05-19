[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getLanguagePackString](./get-language-pack-string.md)

# getLanguagePackString

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getLanguagePackString(languagePackDatabasePath: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, localizationTarget: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, languagePackId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`LanguagePackStringValue`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/LanguagePackStringValue.html)

Suspend function, which returns a string stored in the local database from the specified
localization target and language pack by its key. Returns a 404 error if the string is not found.
This is an offline method. Can be called before authorization. Can be called synchronously.

### Parameters

`languagePackDatabasePath` - Path to the language pack database in which strings are stored.

`localizationTarget` - Localization target to which the language pack belongs.

`languagePackId` - Language pack identifier.

`key` - Language pack key of the string to be returned.

**Return**
[LanguagePackStringValue](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/LanguagePackStringValue.html) This class is an abstract base class.


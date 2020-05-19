[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [importContacts](./import-contacts.md)

# importContacts

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.importContacts(contacts: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Contact`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Contact.html)`>?): `[`ImportedContacts`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ImportedContacts.html)

Suspend function, which adds new contacts or edits existing contacts by their phone numbers;
contacts' user identifiers are ignored.

### Parameters

`contacts` - The list of contacts to import or edit; contacts' vCard are ignored and are not
imported.

**Return**
[ImportedContacts](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ImportedContacts.html) Represents the result of an ImportContacts request.


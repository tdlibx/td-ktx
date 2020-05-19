[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [changeImportedContacts](./change-imported-contacts.md)

# changeImportedContacts

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.changeImportedContacts(contacts: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Contact`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Contact.html)`>?): `[`ImportedContacts`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ImportedContacts.html)

Suspend function, which changes imported contacts using the list of current user contacts saved
on the device. Imports newly added contacts and, if at least the file database is enabled, deletes
recently deleted contacts. Query result depends on the result of the previous query, so only one
query is possible at the same time.

### Parameters

`contacts` - The new list of contacts, contact's vCard are ignored and are not imported.

**Return**
[ImportedContacts](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ImportedContacts.html) Represents the result of an ImportContacts request.


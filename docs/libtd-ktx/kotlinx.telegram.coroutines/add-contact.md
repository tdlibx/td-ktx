---
title: addContact - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [addContact](./add-contact.html)

# addContact

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.addContact(contact: `[`Contact`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Contact.html)`?, sharePhoneNumber: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which adds a user to the contact list or edits an existing contact by their
user identifier.

### Parameters

`contact` - The contact to add or edit; phone number can be empty and needs to be specified
only if known, vCard is ignored.

`sharePhoneNumber` - True, if the new contact needs to be allowed to see current user's phone
number. A corresponding rule to userPrivacySettingShowPhoneNumber will be added if needed. Use the
field UserFullInfo.needPhoneNumberPrivacyException to check whether the current user needs to be
asked to share their phone number.
---
title: getUserProfilePhotos - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getUserProfilePhotos](./get-user-profile-photos.html)

# getUserProfilePhotos

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getUserProfilePhotos(userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`UserProfilePhotos`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UserProfilePhotos.html)

Suspend function, which returns the profile photos of a user. The result of this query may be
outdated: some photos might have been deleted already.

### Parameters

`userId` - User identifier.

`offset` - The number of photos to skip; must be non-negative.

`limit` - The maximum number of photos to be returned; up to 100.

**Return**
[UserProfilePhotos](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UserProfilePhotos.html) Contains part of the list of user photos.


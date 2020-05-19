[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [UserKtx](index.md) / [getProfilePhotos](./get-profile-photos.md)

# getProfilePhotos

`open suspend fun `[`User`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.User.html)`.getProfilePhotos(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`UserProfilePhotos`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UserProfilePhotos.html)

Suspend function, which returns the profile photos of a user. The result of this query may be
outdated: some photos might have been deleted already.

### Parameters

`offset` - The number of photos to skip; must be non-negative.

`limit` - The maximum number of photos to be returned; up to 100.

**Return**
[TdApi.UserProfilePhotos](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UserProfilePhotos.html) Contains part of the list of user photos.


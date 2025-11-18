# Telegram Flow

Kotlin Coroutines extensions for Telegram API [TDLib](https://github.com/tdlib/td) (Telegram Database
 library)

## Sample Compose client

The legacy XML sample has been removed and the modern Compose-only sample application now lives under
[`sample/app`](sample/app). It targets the latest Android SDKs, uses Material 3 components, and is the
source that is built in CI for every `master` update. You can open the root project in Android Studio
and run the `sample-app` configuration to try it locally.

## Automated debug releases

Each push to the `master` branch triggers the [Sample app deep-debug build](.github/workflows/sample-app-debug.yml)
workflow. The pipeline builds the dedicated `deepDebug` variant from `sample/app`, stores the generated
`app-deep-debug.apk` as a workflow artifact, and publishes a prerelease on the repository's Releases page.
Binary artifacts are intentionally not committed to source control; download the latest debug APK directly
from the Releases tab after CI finishes.

If you need the TDLib Java bindings locally, download the prebuilt archive from the
[tdlibx/td releases page](https://github.com/tdlibx/td/releases) or declare the existing dependency
`com.github.tdlibx:td:1.8.6` in your Gradle project instead of adding `.jar` files to this repository.

### Gradle wrapper

The repository keeps only the `gradlew` scripts and wrapper properties in Git. Fetch the
matching `gradle-wrapper.jar` from the official Gradle distribution service if you need to run
the wrapper locally:

1. Download [`gradle-8.14.3-bin.zip`](https://services.gradle.org/distributions/gradle-8.14.3-bin.zip).
2. Extract `gradle-8.14.3/lib/gradle-wrapper.jar` from the archive.
3. Copy it into `gradle/wrapper/gradle-wrapper.jar` before invoking `./gradlew`.

Alternatively, run `gradle wrapper --gradle-version 8.14.3` from a machine with Gradle installed to
regenerate the file.

## Using library

The main class of the library is [TelegramFlow]. It converts Telegram Updates handlers to the
Kotlin Coroutine Flows and Telegram callback-style Functions to Kotlin Coroutine suspend functions

### Start using

1. Create instance of [TelegramFlow]
2. You can collect flow of TdApi.Objects from the TelegramFlow instance and its [flow extensions].
3. Call [attachClient] function of the [TelegramFlow] instance to connect it to the Telegram Client.
4. Now you can use numerous [extension functions] to send data to the Telegram API and collect data
 from [flow extensions]
 
### Using Flows

[Any update](https://core.telegram.org/tdlib/getting-started#handling-updates) listed in TdApi can be collected by corresponding flow extension of the [TelegramFlow].

```Kotlin
telegramFlow.userStatusFlow().collect { status: TdApi.UpdateUserStatus ->
    // collect UpdateUserStatus from Telegram
}
```

For the Updates where there is the only field available inside, Update class is suppress by the flow extension and return data itself, for example: 

```Kotlin 
telegramFlow.authorizationStateFlow().collect { state: TdApi.AuthorizationState ->
    // collect AuthorizationState instead of TdApi.UpdateAuthorizationState since there is no other data inside
}
```

### Using Functions

[Any funcrion](https://core.telegram.org/tdlib/docs/classtd_1_1td__api_1_1_function.html) listed in TdApi can be called via corresponding coroutine extension

```Kotlin
suspend fun sendCode(code: String) {
    api.checkAuthenticationCode(code) // send TdApi.CheckAuthenticationCode(code) to the Client
}
```

### Using extensions interfaces

Library provides [extension interfaces](https://tdlibx.github.io/td-ktx/docs/libtd-ktx/kotlinx.telegram.extensions/index.html) to access specific Telegram Object's extensions. This allows you to use the library full potential

```Kotlin
class YourTelegramClass : UserKtx {
    // Instance of the TelegramFlow connecting extensions to the API 
    override val api = TelegramFlow()
    // Flow that returns updates of the user as a full UserInfo
    val fullInfoFlow: Flow<TdApi.UserFullInfo> = api.userFlow().map { user ->
        user.getFullInfo() // call TdApi.GetUserFullInfo(userId) with id of the user instance
    }
}
```
All possible extensions for Telegram entities can be accessed via [TelegramKtx]. List and description of available extension interfaces can be found [here](https://tdlibx.github.io/td-ktx/docs/libtd-ktx/kotlinx.telegram.extensions/index.html)

[TelegramFlow]: https://tdlibx.github.io/td-ktx/docs/libtd-ktx/kotlinx.telegram.core/-telegram-flow/index.html
[flow extensions]: https://tdlibx.github.io/td-ktx/docs/libtd-ktx/kotlinx.telegram.flows/index.html
[attachClient]: https://tdlibx.github.io/td-ktx/docs/libtd-ktx/kotlinx.telegram.core/-telegram-flow/attach-client.html
[extension functions]: https://tdlibx.github.io/td-ktx/docs/libtd-ktx/kotlinx.telegram.coroutines/index.html
[TelegramKtx]: https://tdlibx.github.io/td-ktx/docs/libtd-ktx/kotlinx.telegram.extensions/-telegram-ktx/index.html

# Telegram Flow

Kotlin Coroutines extensions for Telegram API [TDLib](https://github.com/tdlib/td) (Telegram Database
 library)

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

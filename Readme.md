# Telegram Flow for TDLib

Telegram Flow is a Kotlin-first extension toolkit for [TDLib](https://github.com/tdlib/td) that turns callback-based Telegram API calls into coroutines and flows. It keeps your client code concise while exposing idiomatic Compose- and coroutine-friendly APIs.

## Features
- **Coroutine wrappers** for every TDLib function so you can `suspend` instead of juggling callbacks.
- **Flow-based updates** that emit strongly typed Telegram updates with sensible defaults.
- **Extension interfaces** to organize API access around Telegram entities (users, chats, messages, etc.).
- **Compose-ready**: works seamlessly with `ViewModel` scopes and state flows.

## Setup
Add the library dependency from Maven Central:

```kotlin
implementation("com.github.tdlibx:td:1.8.6")
implementation(project(":libtd-ktx"))
```

The project ships a TDLib wrapper module (`libtd-ktx`) and a Compose sample under `sample/` that demonstrates usage with Hilt and the Navigation 3 typed destination APIs.

## Getting started
1. Create a single `TelegramFlow` instance and keep it in a long-lived scope (e.g., via DI).
2. Attach a TDLib client once at startup:

```kotlin
val telegramFlow = TelegramFlow()
telegramFlow.attachClient()
```

3. Provide required TDLib parameters when prompted by the authorization state flow:

```kotlin
telegramFlow.authorizationStateFlow().collect { state ->
    if (state is TdApi.AuthorizationStateWaitTdlibParameters) {
        telegramFlow.setTdlibParameters(
            databaseDirectory = "/data/user/0/<your.package>/files/td",
            apiId = BuildConfig.TELEGRAM_APP_ID,
            apiHash = BuildConfig.TELEGRAM_APP_HASH,
            // ...other parameters
        )
    }
}
```

4. Send authentication information with coroutine calls:

```kotlin
telegramFlow.setAuthenticationPhoneNumber(phone, null)
telegramFlow.checkAuthenticationCode(code)
telegramFlow.checkAuthenticationPassword(password)
```

## Collecting updates
Every TDLib update has a matching flow extension. Example: tracking user presence changes.

```kotlin
telegramFlow.userStatusFlow().collect { status ->
    val user = telegramFlow.getUser(status.userId)
    // update UI with latest user status
}
```

For updates that only wrap a single value, the flow returns the inner type directly, e.g. `authorizationStateFlow()` emits `TdApi.AuthorizationState` instances.

## Calling Telegram functions
Each TDLib function is exposed as a suspending extension on `TelegramFlow`:

```kotlin
suspend fun fetchSelf(): TdApi.User = telegramFlow.getMe()
```

Explore the full API surface in the [generated docs](https://tdlibx.github.io/td-ktx/docs/libtd-ktx/).

## Samples
A minimal Compose sample lives in [`sample/app`](sample/app). It wires `TelegramFlow` with Hilt, demonstrates handling the authorization flow, and renders online users with Navigation Compose.

## License
This project is distributed under the Apache 2.0 License. See [LICENSE](LICENSE) for details.

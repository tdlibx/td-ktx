# Sample App Overview

This sample demonstrates how to build a tabbed Telegram client UI using the td-ktx wrappers and Jetpack Compose.

## Standalone consumer build

This directory is a self-contained Gradle project. It does NOT depend on local copies of `libtd` / `libtd-ktx`. Instead it consumes:

- `io.github.tdlibx:td-ktx:1.8.56-RC10`
- `io.github.tdlibx:td:1.8.56-RC10`

from Maven Central (and `mavenLocal()` while developing versions that have not yet been released). The native `libtdjson.dylib` is downloaded by the `io.github.tdlibx.tdlib-xcframework` Gradle plugin from the `io.github.tdlibx:td-libtdjson:1.8.56-RC10` Maven artifact.

### Build & run

```bash
# macOS desktop
./gradlew :app:runDebugExecutableMacosArm64

# Android (requires SDK + emulator/device)
./gradlew :app:installDebug
```

### Updating the version

Bump `tdlib` and `tdktx` in `gradle/libs.versions.toml` (and `gradle.properties`'s
`tdlibx.tdlibJsonVersion` if present) — they always stay aligned.

## Business Logic Highlights
1. Tabbed main screen with the existing "User Online" tab and a "Threads" tab.
2. Threads feature aggregates group chat messages with reply trees, showing each root message with its nested replies.
3. Thread results are streamed incrementally so the UI can display found threads while remaining chats are still processing.
4. Messages show the sender name in bold using the "Name: message" format for both roots and replies.
5. Photos attached to messages are rendered alongside text when available.
6. Reply-only messages are not shown as separate thread roots; each root appears once with its full reply tree.
7. Telegram API access is centralized in a repository, with dedicated use cases for fetching group chats and building threads per chat.
8. Message reactions are surfaced alongside each message in a thread when available.
9. Threads tab UI mirrors modern X/Threads-style cards with avatar placeholders, chat context, reply connectors, and pill reactions.
10. Group chat avatars are fetched and shown on thread cards while sender names remain within message content to avoid duplication.

Update this log whenever new business-level functionality is added to the sample.

## UI tests

Instrumented Compose UI tests live under `app/src/androidInstrumentedTest/`. They cover the config screen, login screen, main tabs, and `MainActivity` navigation without requiring a logged-in Telegram account.

Run on a connected emulator or device:

```bash
./gradlew :app:connectedDebugAndroidTest
```

### Telegram test environment (test DC)

TDLib supports a separate Telegram **test environment** for development. Pass `useTestDc = true` in `setTdlibParameters` when authorization state is `authorizationStateWaitTdlibParameters`:

- [setTdlibParameters documentation](https://core.telegram.org/tdlib/docs/classtd_1_1td__api_1_1set_tdlib_parameters.html)
- [Getting started with TDLib](https://core.telegram.org/tdlib/getting-started)

The sample app exposes this via the **Use Telegram test environment** toggle on the config screen. Test DC is isolated from production; you need a separate test account (same API id/hash from [my.telegram.org](https://my.telegram.org)).

`TdLibTestEnvironmentIntegrationTest` verifies TDLib reaches the phone-number auth state on test DC. It is skipped unless credentials are supplied:

```bash
./gradlew :app:connectedDebugAndroidTest \
  -Pandroid.testInstrumentationRunnerArguments.telegram_app_id=YOUR_ID \
  -Pandroid.testInstrumentationRunnerArguments.telegram_app_hash=YOUR_HASH
```

# Sample App Overview

This sample demonstrates how to build a tabbed Telegram client UI using the td-ktx wrappers and Jetpack Compose.

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

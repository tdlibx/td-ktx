# Sample App Business Logic Requests

This log tracks the business-level feature requests implemented in the sample app. Bug fixes and refactors are excluded.

1. Add tabbed main screen with existing "User Online" tab and a new "Threads" tab.
2. Build Threads feature that aggregates group messages with reply threads, showing roots with nested replies.
3. Stream thread results incrementally so the UI can show found threads while other chats are still loading.
4. Display sender names in bold with the "Name: message" format for roots and replies.
5. Render photos for messages when available alongside their text.
6. Avoid showing reply-only messages as separate thread roots; roots appear once with their reply tree.
7. Centralize Telegram API access via repository, with dedicated use cases for fetching group chats and building threads per chat.
8. Maintain this log in the sample module and update it with each new business request.

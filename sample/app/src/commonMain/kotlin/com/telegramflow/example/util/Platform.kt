package com.telegramflow.example.util

import androidx.compose.runtime.Composable

expect fun formatThreadDateRange(startSeconds: Long, endSeconds: Long): String

@Composable
expect fun ReportDrawnWhen(block: () -> Boolean)

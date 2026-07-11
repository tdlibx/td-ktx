package com.telegramflow.example.util

import androidx.compose.runtime.Composable
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter

private val threadDayFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MMM d")
private val threadDayYearFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy")

actual fun formatThreadDateRange(startSeconds: Long, endSeconds: Long): String {
    val zone = ZoneId.systemDefault()
    val start = Instant.ofEpochSecond(minOf(startSeconds, endSeconds)).atZone(zone).toLocalDate()
    val end = Instant.ofEpochSecond(maxOf(startSeconds, endSeconds)).atZone(zone).toLocalDate()
    val currentYear = LocalDate.now(zone).year
    val sameYear = start.year == end.year
    val sameMonth = sameYear && start.month == end.month
    val includeYear = !sameYear || start.year != currentYear

    if (start == end) {
        return if (includeYear) threadDayYearFormatter.format(start) else threadDayFormatter.format(start)
    }

    if (sameYear && sameMonth) {
        val dayRange = "${threadDayFormatter.format(start)} – ${end.dayOfMonth}"
        return if (includeYear) "$dayRange, ${start.year}" else dayRange
    }

    if (sameYear) {
        val base = "${threadDayFormatter.format(start)} – ${threadDayFormatter.format(end)}"
        return if (includeYear) "$base, ${start.year}" else base
    }

    val startLabel = threadDayYearFormatter.format(start)
    val endLabel = threadDayYearFormatter.format(end)
    return "$startLabel – $endLabel"
}

@Composable
actual fun ReportDrawnWhen(block: () -> Boolean) {
    androidx.activity.compose.ReportDrawnWhen(block)
}

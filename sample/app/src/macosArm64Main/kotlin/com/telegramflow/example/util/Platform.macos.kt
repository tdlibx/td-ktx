package com.telegramflow.example.util

import androidx.compose.runtime.Composable
import platform.Foundation.*

actual fun formatThreadDateRange(startSeconds: Long, endSeconds: Long): String {
    val calendar = NSCalendar.currentCalendar
    val startDate = NSDate.dateWithTimeIntervalSince1970(minOf(startSeconds, endSeconds).toDouble())
    val endDate = NSDate.dateWithTimeIntervalSince1970(maxOf(startSeconds, endSeconds).toDouble())

    val units = NSCalendarUnitYear or NSCalendarUnitMonth or NSCalendarUnitDay
    val startComponents = calendar.components(units, fromDate = startDate)
    val endComponents = calendar.components(units, fromDate = endDate)
    val currentComponents = calendar.components(NSCalendarUnitYear, fromDate = NSDate())

    val currentYear = currentComponents.year
    val sameYear = startComponents.year == endComponents.year
    val sameMonth = sameYear && startComponents.month == endComponents.month
    val includeYear = !sameYear || startComponents.year != currentYear

    val dayFormatter = NSDateFormatter().apply {
        dateFormat = "MMM d"
    }
    val dayYearFormatter = NSDateFormatter().apply {
        dateFormat = "MMM d, yyyy"
    }

    if (startComponents.year == endComponents.year &&
        startComponents.month == endComponents.month &&
        startComponents.day == endComponents.day
    ) {
        return if (includeYear) dayYearFormatter.stringFromDate(startDate) else dayFormatter.stringFromDate(startDate)
    }

    if (sameYear && sameMonth) {
        val dayRange = "${dayFormatter.stringFromDate(startDate)} – ${endComponents.day}"
        return if (includeYear) "$dayRange, ${startComponents.year}" else dayRange
    }

    if (sameYear) {
        val base = "${dayFormatter.stringFromDate(startDate)} – ${dayFormatter.stringFromDate(endDate)}"
        return if (includeYear) "$base, ${startComponents.year}" else base
    }

    val startLabel = dayYearFormatter.stringFromDate(startDate)
    val endLabel = dayYearFormatter.stringFromDate(endDate)
    return "$startLabel – $endLabel"
}

@Composable
actual fun ReportDrawnWhen(block: () -> Boolean) {
    // No-op on macOS
}

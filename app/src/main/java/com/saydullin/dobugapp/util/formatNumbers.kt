package com.saydullin.dobugapp.util

import java.util.Locale

fun formatNumbers(count: Long): String {
    return when {
        count == 0L -> ""
        count < 1_000 -> count.toString()
        count < 1_000_000 -> String.format(Locale.getDefault(), "%.1fK", count / 1_000.0).removeSuffix(".0K") + "K"
        count < 1_000_000_000 -> String.format(Locale.getDefault(), "%.1fM", count / 1_000_000.0).removeSuffix(".0M") + "M"
        else -> String.format(Locale.getDefault(), "%.1fB", count / 1_000_000_000.0).removeSuffix(".0B") + "B"
    }
}



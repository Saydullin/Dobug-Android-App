package com.saydullin.domain.ext

import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

fun parseIsoDateToMillis(dateString: String): Long {
    return try {
        val dateTime = OffsetDateTime.parse(dateString, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
        dateTime.toInstant().toEpochMilli()
    } catch (e: Exception) {
        e.printStackTrace()
        0L
    }
}
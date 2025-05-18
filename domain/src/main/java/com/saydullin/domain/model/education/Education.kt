package com.saydullin.domain.model.education

data class Education(
    val id: Long,
    val title: String?,
    val description: String?,
    val startedAt: Long?,
    val endedAt: Long?
)
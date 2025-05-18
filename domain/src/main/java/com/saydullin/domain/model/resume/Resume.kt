package com.saydullin.domain.model.resume

data class Resume(
    val id: Long,
    val path: String?,
    val userId: Long,
    val createdAt: Long?,
    val editedAt: Long?
)

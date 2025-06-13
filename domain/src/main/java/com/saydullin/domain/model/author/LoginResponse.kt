package com.saydullin.domain.model.author

data class LoginResponse(
    val userId: Long,
    val token: String?
)
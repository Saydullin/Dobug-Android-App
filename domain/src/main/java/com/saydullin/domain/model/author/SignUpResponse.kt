package com.saydullin.domain.model.author

data class SignUpResponse(
    val userId: Long,
    val email: String,
    val username: String,
    val token: String?
)



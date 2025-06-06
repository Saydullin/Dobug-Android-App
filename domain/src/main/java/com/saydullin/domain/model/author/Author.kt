package com.saydullin.domain.model.author

data class Author(
    val id: Long,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val username: String,
    val email: String,
    val bio: String,
) {

    fun getFullName(): String {
        return "$middleName $firstName $lastName".trim()
    }

}

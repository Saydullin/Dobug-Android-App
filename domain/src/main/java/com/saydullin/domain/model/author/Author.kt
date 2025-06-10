package com.saydullin.domain.model.author

data class Author(
    val id: Long,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val username: String,
    val bio: String,
) {

    companion object {
        fun getAnonymous(): Author {
            return Author(
                id = -1L,
                "Anonymous",
                "",
                "",
                "",
                "",
            )
        }
    }

    fun getFullName(): String {
        return "$middleName $firstName $lastName".trim()
    }

}

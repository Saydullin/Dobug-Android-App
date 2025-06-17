package com.saydullin.domain.model.author

import com.saydullin.domain.model.profession.Profession

data class Author(
    val id: Long,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val username: String,
    val bio: String,
    val professions: List<Profession>
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
                listOf()
            )
        }
    }

    fun getFullName(): String {
        return "$middleName $firstName $lastName".trim()
    }

}

package com.saydullin.data.db.mapper.author

import com.saydullin.data.db.entity.author.AuthorEntity
import com.saydullin.data.db.mapper.Mapper
import com.saydullin.domain.model.author.Author
import javax.inject.Inject

class AuthorToAuthorEntityMapper @Inject constructor(
): Mapper<Author, AuthorEntity> {

    override fun map(from: Author): AuthorEntity {
        return AuthorEntity(
            id = from.id,
            firstName = from.firstName,
            middleName = from.middleName,
            lastName = from.lastName,
            username = from.username,
            bio = from.bio,
            imagePath = from.imagePath ?: ""
        )
    }

}
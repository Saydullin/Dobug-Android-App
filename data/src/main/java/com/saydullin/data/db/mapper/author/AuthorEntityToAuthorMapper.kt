package com.saydullin.data.db.mapper.author

import com.saydullin.data.db.entity.author.AuthorEntity
import com.saydullin.data.db.mapper.Mapper
import com.saydullin.domain.model.author.Author
import javax.inject.Inject

class AuthorEntityToAuthorMapper @Inject constructor(

): Mapper<AuthorEntity, Author> {

    override fun map(from: AuthorEntity): Author {
        return Author(
            id = from.id,
            firstName = from.firstName,
            middleName = from.middleName,
            lastName = from.lastName,
            username = from.username,
            email = from.email,
            bio = from.bio,
        )
    }

}
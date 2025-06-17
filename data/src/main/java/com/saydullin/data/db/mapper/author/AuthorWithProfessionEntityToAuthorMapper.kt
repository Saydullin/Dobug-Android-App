package com.saydullin.data.db.mapper.author

import com.saydullin.data.db.mapper.Mapper
import com.saydullin.data.db.mapper.profession.ProfessionEntityToProfessionMapper
import com.saydullin.data.model.author.AuthorWithProfessionEntity
import com.saydullin.domain.model.author.Author
import javax.inject.Inject

class AuthorWithProfessionEntityToAuthorMapper @Inject constructor(
    private val professionEntityToProfessionMapper: ProfessionEntityToProfessionMapper
): Mapper<AuthorWithProfessionEntity, Author> {

    override fun map(from: AuthorWithProfessionEntity): Author {
        return Author(
            id = from.author.id,
            firstName = from.author.firstName,
            middleName = from.author.middleName,
            lastName = from.author.lastName,
            username = from.author.username,
            bio = from.author.bio,
            professions = from.professions.map { professionEntityToProfessionMapper.map(it) }
        )
    }

}



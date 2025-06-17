package com.saydullin.data.db.mapper.author

import com.saydullin.data.db.entity.author.AuthorProfessionEntity
import com.saydullin.data.db.mapper.Mapper
import com.saydullin.data.model.author.AuthorProfession
import javax.inject.Inject

class AuthorProfessionEntityToAuthorProfessionMapper @Inject constructor(
): Mapper<AuthorProfessionEntity, AuthorProfession> {

    override fun map(from: AuthorProfessionEntity): AuthorProfession {
        return AuthorProfession(
            authorId = from.authorId,
            professionId = from.professionId,
        )
    }

}
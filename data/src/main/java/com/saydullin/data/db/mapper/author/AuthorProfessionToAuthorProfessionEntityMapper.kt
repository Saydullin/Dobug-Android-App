package com.saydullin.data.db.mapper.author

import com.saydullin.data.db.entity.author.AuthorProfessionEntity
import com.saydullin.data.db.mapper.Mapper
import com.saydullin.data.model.author.AuthorProfession
import javax.inject.Inject

class AuthorProfessionToAuthorProfessionEntityMapper @Inject constructor(
): Mapper<AuthorProfession, AuthorProfessionEntity> {

    override fun map(from: AuthorProfession): AuthorProfessionEntity {
        return AuthorProfessionEntity(
            authorId = from.authorId,
            professionId = from.professionId,
        )
    }

}
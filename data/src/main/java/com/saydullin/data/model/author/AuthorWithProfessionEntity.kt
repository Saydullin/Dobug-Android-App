package com.saydullin.data.model.author

import com.saydullin.data.db.entity.author.AuthorEntity
import com.saydullin.data.db.entity.profession.ProfessionEntity

data class AuthorWithProfessionEntity(
    val author: AuthorEntity,
    val professions: List<ProfessionEntity>
)



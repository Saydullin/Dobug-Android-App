package com.saydullin.data.db.entity.author

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.saydullin.data.db.entity.profession.ProfessionEntity

data class AuthorWithRelations(
    @Embedded
    val author: AuthorEntity?,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = AuthorProfessionEntity::class,
            parentColumn = "authorId",
            entityColumn = "professionId"
        )
    )
    val professions: List<ProfessionEntity>
)



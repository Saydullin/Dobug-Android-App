package com.saydullin.data.db.entity.author

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.saydullin.data.db.entity.profession.ProfessionEntity

@Entity(
    tableName = "author_profession",
    foreignKeys = [
        ForeignKey(
            entity = AuthorEntity::class,
            parentColumns = ["id"],
            childColumns = ["authorId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ProfessionEntity::class,
            parentColumns = ["id"],
            childColumns = ["professionId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["authorId"]),
        Index(value = ["professionId"])
    ]
)
data class AuthorProfessionEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val authorId: Long,
    val professionId: Long,
)



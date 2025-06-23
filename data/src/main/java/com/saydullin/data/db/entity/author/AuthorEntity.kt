package com.saydullin.data.db.entity.author

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("author")
data class AuthorEntity(
    @PrimaryKey(autoGenerate = false) val id: Long,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val username: String,
    val bio: String,
    val imagePath: String,
)



package com.saydullin.data.db.entity.media

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("media")
data class MediaEntity(
    @PrimaryKey(autoGenerate = false) val id: Long,
    val imageUrl: String,
    val alt: String,
)

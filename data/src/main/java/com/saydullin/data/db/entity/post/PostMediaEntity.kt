package com.saydullin.data.db.entity.post

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("post_media")
data class PostMediaEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val postId: Long,
    val mediaId: Long,
)

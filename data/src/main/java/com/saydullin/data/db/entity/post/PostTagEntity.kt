package com.saydullin.data.db.entity.post

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("post_tag")
data class PostTagEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val postId: Long,
    val tagId: Long,
)

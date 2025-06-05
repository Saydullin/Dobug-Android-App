package com.saydullin.data.db.entity.post

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostEntity(
    @PrimaryKey(autoGenerate = false) val id: Long = 0,
    @ColumnInfo("content") val content: String,
    @ColumnInfo("tag_post_id") val tagPostId: Long,
    @ColumnInfo("views") val views: Long,
    @ColumnInfo("likes") val likes: Long,
    @ColumnInfo("reposts") val reposts: Long,
    @ColumnInfo("comments") val comments: Long,
    @ColumnInfo("created_at") val createdAt: Long,
    @ColumnInfo("updated_at") val updatedAt: Long,
    @ColumnInfo("status") val status: Int,
    @ColumnInfo("image_id") val imageId: Long,
    @ColumnInfo("author_id") val authorId: Long,
)

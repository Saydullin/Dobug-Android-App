package com.saydullin.data.db.entity.post

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post")
data class PostEntity(
    @PrimaryKey(autoGenerate = false) val id: Long = 0,
    @ColumnInfo("content") val content: String,
    @ColumnInfo("views") val views: Long,
    @ColumnInfo("likes") val likes: Long,
    @ColumnInfo("reposts") val reposts: Long,
    @ColumnInfo("comments") val comments: Long,
    @ColumnInfo("created_at") val createdAt: Long,
    @ColumnInfo("updated_at") val updatedAt: Long,
    @ColumnInfo("status") val status: Int,
    @ColumnInfo("author_id") val authorId: Long,
)



package com.saydullin.data.db.entity.post.paging

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_post_keys")
data class RemotePostKeysEntity(
    @PrimaryKey val postId: Long,
    val prevKey: Int?,
    val nextKey: Int?
)
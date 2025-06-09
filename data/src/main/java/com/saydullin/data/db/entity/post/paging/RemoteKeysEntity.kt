package com.saydullin.data.db.entity.post.paging

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys")
data class RemoteKeysEntity(
    @PrimaryKey val postId: Long,
    val prevKey: Int?,
    val nextKey: Int?
)
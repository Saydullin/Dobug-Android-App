package com.saydullin.data.db.dao.post

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saydullin.data.db.entity.post.paging.RemotePostKeysEntity

@Dao
interface RemotePostKeysDao {

    @Query("SELECT * FROM remote_post_keys WHERE postId = :postId")
    suspend fun remoteKeysUserId(postId: Long): RemotePostKeysEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<RemotePostKeysEntity>)

    @Query("DELETE FROM remote_post_keys")
    suspend fun clear()

}
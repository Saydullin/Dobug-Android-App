package com.saydullin.data.db.dao.postTag

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saydullin.data.db.entity.post.PostTagEntity

@Dao
interface PostTagDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(postTagList: List<PostTagEntity>): List<Long>

    @Query("DELETE FROM post_tag")
    fun clear(): Int

}
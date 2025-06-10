package com.saydullin.data.db.dao.tag

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saydullin.data.db.entity.tag.TagEntity

@Dao
interface TagDao {

    @Query("SELECT * FROM tag")
    fun getTags(): List<TagEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tags: List<TagEntity>): List<Long>

    @Query("DELETE FROM tag")
    fun clear(): Int

}
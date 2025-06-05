package com.saydullin.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saydullin.data.db.entity.post.PostEntity

@Dao
interface PostDao {

    @Query("SELECT * FROM PostEntity")
    fun getAllPosts(): List<PostEntity>

    @Query("SELECT * FROM PostEntity WHERE id = :id")
    fun getPostById(id: Long): PostEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(posts: List<PostEntity>): List<Long>

    @Delete
    fun delete(posts: List<PostEntity>): Int

}
package com.saydullin.data.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.saydullin.data.db.entity.post.PostEntity
import com.saydullin.data.db.entity.post.PostWithRelations

@Dao
interface PostDao {

    @Transaction
    @Query("SELECT * FROM post")
    fun getAllPosts(): PagingSource<Int, PostWithRelations>

    @Query("SELECT * FROM post WHERE id = :id")
    fun getPostById(id: Long): PostWithRelations?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(posts: List<PostEntity>): List<Long>

    @Query("DELETE FROM post")
    fun clear(): Int

}



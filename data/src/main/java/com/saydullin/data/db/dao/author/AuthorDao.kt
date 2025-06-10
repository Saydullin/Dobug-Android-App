package com.saydullin.data.db.dao.author

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saydullin.data.db.entity.author.AuthorEntity

@Dao
interface AuthorDao {

    @Query("SELECT * FROM author WHERE username LIKE :username")
    fun getAuthorByUsername(username: String): List<AuthorEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(authorList: List<AuthorEntity>): List<Long>

    @Query("DELETE FROM author")
    fun clear(): Int

}
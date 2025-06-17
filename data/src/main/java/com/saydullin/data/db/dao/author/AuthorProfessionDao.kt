package com.saydullin.data.db.dao.author

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.saydullin.data.db.entity.author.AuthorProfessionEntity

@Dao
interface AuthorProfessionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(authorProfessionList: List<AuthorProfessionEntity>): List<Long>

}
package com.saydullin.data.db.dao.profession

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saydullin.data.db.entity.profession.ProfessionEntity

@Dao
interface ProfessionDao {

    @Query("SELECT * FROM profession LIMIT 10")
    fun professions(): List<ProfessionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(professions: List<ProfessionEntity>): List<Long>

}
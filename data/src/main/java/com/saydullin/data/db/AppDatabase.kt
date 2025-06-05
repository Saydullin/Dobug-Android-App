package com.saydullin.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saydullin.data.db.dao.PostDao
import com.saydullin.data.db.entity.post.PostEntity

@Database(
    entities = [
        PostEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getPostDao(): PostDao

}



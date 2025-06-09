package com.saydullin.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saydullin.data.db.dao.PostDao
import com.saydullin.data.db.dao.RemoteKeysDao
import com.saydullin.data.db.entity.author.AuthorEntity
import com.saydullin.data.db.entity.media.MediaEntity
import com.saydullin.data.db.entity.post.PostEntity
import com.saydullin.data.db.entity.post.PostMediaEntity
import com.saydullin.data.db.entity.post.PostTagEntity
import com.saydullin.data.db.entity.post.paging.RemoteKeysEntity
import com.saydullin.data.db.entity.tag.TagEntity

@Database(
    entities = [
        PostEntity::class,
        RemoteKeysEntity::class,
        PostTagEntity::class,
        PostMediaEntity::class,
        TagEntity::class,
        MediaEntity::class,
        AuthorEntity::class,
    ],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getPostDao(): PostDao

    abstract fun getRemoteKeysDao(): RemoteKeysDao

}



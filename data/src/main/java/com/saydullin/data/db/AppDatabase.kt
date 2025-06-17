package com.saydullin.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saydullin.data.db.dao.author.AuthorDao
import com.saydullin.data.db.dao.author.AuthorProfessionDao
import com.saydullin.data.db.dao.post.PostDao
import com.saydullin.data.db.dao.post.RemotePostKeysDao
import com.saydullin.data.db.dao.postTag.PostTagDao
import com.saydullin.data.db.dao.profession.ProfessionDao
import com.saydullin.data.db.dao.tag.TagDao
import com.saydullin.data.db.entity.author.AuthorEntity
import com.saydullin.data.db.entity.author.AuthorProfessionEntity
import com.saydullin.data.db.entity.media.MediaEntity
import com.saydullin.data.db.entity.post.PostEntity
import com.saydullin.data.db.entity.post.PostMediaEntity
import com.saydullin.data.db.entity.post.PostTagEntity
import com.saydullin.data.db.entity.post.paging.RemotePostKeysEntity
import com.saydullin.data.db.entity.profession.ProfessionEntity
import com.saydullin.data.db.entity.tag.TagEntity

@Database(
    entities = [
        PostEntity::class,
        RemotePostKeysEntity::class,
        PostTagEntity::class,
        PostMediaEntity::class,
        TagEntity::class,
        MediaEntity::class,
        AuthorEntity::class,
        AuthorProfessionEntity::class,
        ProfessionEntity::class,
    ],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getTagDao(): TagDao

    abstract fun getPostDao(): PostDao

    abstract fun getAuthorDao(): AuthorDao

    abstract fun getPostTagDao(): PostTagDao

    abstract fun getProfessionDao(): ProfessionDao

    abstract fun getRemoteKeysDao(): RemotePostKeysDao

    abstract fun getAuthorProfessionDao(): AuthorProfessionDao

}



package com.saydullin.data.di

import android.content.Context
import androidx.room.Room
import com.saydullin.data.db.AppDatabase
import com.saydullin.data.db.dao.author.AuthorDao
import com.saydullin.data.db.dao.post.PostDao
import com.saydullin.data.db.dao.post.RemotePostKeysDao
import com.saydullin.data.db.dao.postTag.PostTagDao
import com.saydullin.data.db.dao.tag.TagDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_db.db"
        ).build()
    }

    @Provides
    fun providePostDao(db: AppDatabase): PostDao {
        return db.getPostDao()
    }

    @Provides
    fun providePostTagDao(db: AppDatabase): PostTagDao {
        return db.getPostTagDao()
    }

    @Provides
    fun provideRemoteKeysDao(db: AppDatabase): RemotePostKeysDao {
        return db.getRemoteKeysDao()
    }

    @Provides
    fun provideTagDao(db: AppDatabase): TagDao {
        return db.getTagDao()
    }

    @Provides
    fun provideAuthorDao(db: AppDatabase): AuthorDao {
        return db.getAuthorDao()
    }

}



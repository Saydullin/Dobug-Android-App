package com.saydullin.data.di

import android.content.Context
import com.saydullin.data.datastore.JwtSecurityDataStore
import com.saydullin.data.db.AppDatabase
import com.saydullin.data.db.dao.post.PostDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UtilsModule {

    @Provides
    @Singleton
    fun provideJwtSecurityDatastore(
        @ApplicationContext context: Context
    ): JwtSecurityDataStore {
        return JwtSecurityDataStore(context)
    }

}
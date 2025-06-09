package com.saydullin.data.di

import com.saydullin.data.repository.PostLocalRepositoryImpl
import com.saydullin.data.repository.PostServerRepositoryImpl
import com.saydullin.domain.repository.post.PostLocalRepository
import com.saydullin.domain.repository.post.PostServerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPostServerRepository(
        postServerRepository: PostServerRepositoryImpl
    ): PostServerRepository

    @Binds
    @Singleton
    abstract fun bindPostLocalRepository(
        postServerRepository: PostLocalRepositoryImpl
    ): PostLocalRepository

}
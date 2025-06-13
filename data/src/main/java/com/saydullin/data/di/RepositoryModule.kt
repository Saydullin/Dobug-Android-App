package com.saydullin.data.di

import com.saydullin.data.repository.auth.AuthRepositoryImpl
import com.saydullin.data.repository.post.PostLocalRepositoryImpl
import com.saydullin.data.repository.post.PostServerRepositoryImpl
import com.saydullin.domain.repository.auth.AuthRepository
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

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepository: AuthRepositoryImpl
    ): AuthRepository

}



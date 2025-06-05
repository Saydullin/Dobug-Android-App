package com.saydullin.data.di

import com.saydullin.domain.repository.post.PostServerRepository
import com.saydullin.domain.usecase.post.GetPostUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun bindGetPostUseCase(
        postServerRepository: PostServerRepository
    ): GetPostUseCase {
        return GetPostUseCase(
            postServerRepository = postServerRepository
        )
    }

}
package com.saydullin.data.di

import com.saydullin.domain.repository.auth.AuthRepository
import com.saydullin.domain.repository.post.PostServerRepository
import com.saydullin.domain.usecase.auth.LoginUseCase
import com.saydullin.domain.usecase.auth.SignUpUseCase
import com.saydullin.domain.usecase.post.GetPostServerUseCase
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
    ): GetPostServerUseCase {
        return GetPostServerUseCase(
            postServerRepository = postServerRepository
        )
    }

    @Provides
    @Singleton
    fun bindLoginUseCase(
        authRepository: AuthRepository
    ): LoginUseCase {
        return LoginUseCase(
            authRepository = authRepository
        )
    }

    @Provides
    @Singleton
    fun bindSignUpUseCase(
        authRepository: AuthRepository
    ): SignUpUseCase {
        return SignUpUseCase(
            authRepository = authRepository
        )
    }

}
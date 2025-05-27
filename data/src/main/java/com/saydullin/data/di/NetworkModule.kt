package com.saydullin.data.di

import com.saydullin.data.server.service.post.GetPostsService
import com.saydullin.domain.config.Config
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Config.SERVER_ADDRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideGetPostService(retrofit: Retrofit): GetPostsService {
        return retrofit.create(GetPostsService::class.java)
    }

}
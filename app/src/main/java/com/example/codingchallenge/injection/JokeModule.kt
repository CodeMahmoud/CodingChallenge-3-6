package com.example.codingchallenge.injection

import com.example.codingchallenge.jokeApi.JokeApi
import com.example.codingchallenge.jokeApi.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object JokeModule {

    @Provides
    @Singleton
    fun provideJokeService(): JokeApi {
        return RetrofitClient.api
    }
}
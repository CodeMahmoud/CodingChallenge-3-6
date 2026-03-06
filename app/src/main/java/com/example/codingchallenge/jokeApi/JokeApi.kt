package com.example.codingchallenge.jokeApi

import com.example.codingchallenge.model.Joke
import retrofit2.http.GET

interface JokeApi {
    @GET("jokes/random")
    suspend fun getRandomJoke(): Joke
}
package com.example.codingchallenge.repository

import com.example.codingchallenge.jokeApi.JokeApi
import com.example.codingchallenge.model.Joke
import javax.inject.Inject

class JokeRepository @Inject constructor(
    private val jokeApi: JokeApi
) {
    suspend fun getRandomJoke(): Joke {
        return jokeApi.getRandomJoke()
    }
}
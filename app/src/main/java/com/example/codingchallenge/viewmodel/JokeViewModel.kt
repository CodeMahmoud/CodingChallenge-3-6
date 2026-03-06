package com.example.codingchallenge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingchallenge.model.Joke
import com.example.codingchallenge.repository.JokeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class JokeViewModel @Inject constructor(
    private val repository: JokeRepository
): ViewModel() {

    private val _joke = MutableStateFlow<Joke?>(null)
    val joke: StateFlow<Joke?> = _joke

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        fetchJoke()
    }

    fun fetchJoke() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null

            try {
                val result = repository.getRandomJoke()
                _joke.value = result
            } catch (e: Exception) {
//                _error.value = "My bad can't get the joke at the moment, click me next time!"
//                _error.value = "Error: ${e.message}"
                _error.value = "Error type: ${e::class.simpleName} - ${e.message}"

            } finally {
                _isLoading.value = false
            }

         }
    }
}
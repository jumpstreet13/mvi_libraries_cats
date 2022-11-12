package com.example.mvi_examples.mvilibraries.mvvm

import com.example.mvi_examples.mvilibraries.Cat

data class CatsUiState(
    val isLoading: Boolean = false,
    val cats: List<Cat> = emptyList(),
    val error: Throwable? = null
)
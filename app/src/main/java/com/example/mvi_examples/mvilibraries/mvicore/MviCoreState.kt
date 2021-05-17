package com.example.mvi_examples.mvilibraries.mvicore

import com.example.mvi_examples.mvilibraries.Cat

data class MviCoreState(
    val isLoading: Boolean = false,
    val cats: List<Cat>? = null
)
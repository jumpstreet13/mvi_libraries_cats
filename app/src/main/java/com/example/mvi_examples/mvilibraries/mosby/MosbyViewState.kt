package com.example.mvi_examples.mvilibraries.mosby

import com.example.mvi_examples.mvilibraries.Cat

data class MosbyViewState(
    val catList: List<Cat>,
    val isLoading: Boolean,
    val error: Throwable?
)
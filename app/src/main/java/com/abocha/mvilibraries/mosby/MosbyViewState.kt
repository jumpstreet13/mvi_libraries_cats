package com.abocha.mvilibraries.mosby

import com.abocha.mvilibraries.Cat

data class MosbyViewState(
    val catList: List<Cat>,
    val isLoading: Boolean,
    val error: Throwable?
)
package com.example.mvi_examples.mvilibraries.roxie

import com.example.mvi_examples.mvilibraries.Cat
import com.ww.roxie.BaseState

data class RoxieState(
    val cats: List<Cat> = emptyList(),
    val isLoading: Boolean = false,
    val isLoadError: Boolean = false,
    val error: Throwable? = null,
    val isIdle: Boolean = false
): BaseState
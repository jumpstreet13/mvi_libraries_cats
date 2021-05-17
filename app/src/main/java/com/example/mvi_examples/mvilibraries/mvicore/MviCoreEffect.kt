package com.example.mvi_examples.mvilibraries.mvicore

import com.example.mvi_examples.mvilibraries.Cat

sealed class MviCoreEffect {
    object StartedLoading : MviCoreEffect()
    data class LoadedCats(val cats: List<Cat>) : MviCoreEffect()
    data class ErrorLoading(val throwable: Throwable) : MviCoreEffect()
}
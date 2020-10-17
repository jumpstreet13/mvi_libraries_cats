package com.abocha.mvilibraries.mvicore

import com.abocha.mvilibraries.Cat

sealed class MviCoreEffect {
    object StartedLoading : MviCoreEffect()
    data class LoadedCats(val cats: List<Cat>) : MviCoreEffect()
    data class ErrorLoading(val throwable: Throwable) : MviCoreEffect()
}
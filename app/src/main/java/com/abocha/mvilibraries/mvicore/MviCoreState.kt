package com.abocha.mvilibraries.mvicore

import com.abocha.mvilibraries.Cat

data class MviCoreState(
    val isLoading: Boolean = false,
    val cats: List<Cat>? = null
)
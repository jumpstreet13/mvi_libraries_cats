package com.example.mvi_examples.mvilibraries.roxie

import com.example.mvi_examples.mvilibraries.Cat

sealed class RoxieChange {
    object Loading : RoxieChange()
    data class Cats(val catsList: List<Cat>) : RoxieChange()
    data class Error(val throwable: Throwable?) : RoxieChange()
}
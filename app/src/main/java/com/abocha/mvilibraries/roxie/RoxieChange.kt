package com.abocha.mvilibraries.roxie

import com.abocha.mvilibraries.Cat

sealed class RoxieChange {
    object Loading : RoxieChange()
    data class Cats(val catsList: List<Cat>) : RoxieChange()
    data class Error(val throwable: Throwable?) : RoxieChange()
}
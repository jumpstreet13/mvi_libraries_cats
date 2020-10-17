package com.abocha.mvilibraries.mvicore

sealed class MviCoreNews {
    data class ErrorExecutingRequest(val throwable: Throwable) : MviCoreNews()
}
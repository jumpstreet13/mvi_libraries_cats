package com.example.mvi_examples.mvilibraries.mvicore

sealed class MviCoreNews {
    data class ErrorExecutingRequest(val throwable: Throwable) : MviCoreNews()
}
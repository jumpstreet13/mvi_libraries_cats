package com.example.mvi_examples.mvilibraries.mvicore

import com.ww.roxie.Reducer

class MviCoreReducerImpl : Reducer<MviCoreState, MviCoreEffect> {

    override fun invoke(state: MviCoreState, change: MviCoreEffect): MviCoreState {
        return when (change) {
            MviCoreEffect.StartedLoading -> state.copy(
                isLoading = true
            )
            is MviCoreEffect.LoadedCats -> state.copy(
                isLoading = false,
                cats = change.cats
            )
            is MviCoreEffect.ErrorLoading -> state.copy(
                isLoading = false
            )
        }
    }
}
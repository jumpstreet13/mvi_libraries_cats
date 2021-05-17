package com.example.mvi_examples.mvilibraries.roxie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvi_examples.mvilibraries.CatsRepository

class RoxieViewModelFactory(
    private val initialState: RoxieState?,
    private val catsRepository: CatsRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RoxieViewModel(initialState, catsRepository) as T
    }
}
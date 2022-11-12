package com.example.mvi_examples.mvilibraries.mvvm

import com.example.mvi_examples.mvilibraries.CatsRepository

class CatsPresenter(
    private val repository: CatsRepository,
    private val view: MyView
) {

    init {
        println("Hello world !")
        // make request
        view.showProgress()
    }
}

interface MyView {
    fun showProgress()
}
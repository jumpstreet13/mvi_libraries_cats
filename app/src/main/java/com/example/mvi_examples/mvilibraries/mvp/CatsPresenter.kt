package com.example.mvi_examples.mvilibraries.mvvm

import com.example.mvi_examples.mvilibraries.Cat
import com.example.mvi_examples.mvilibraries.CatsRepository

class CatsPresenter(
    private val repository: CatsRepository,
) {

    lateinit var view: MyView

    fun attach(view: MyView) {
        this.view = view
    }

    suspend fun loadCats() {
        view.showProgress()
        try {
            val cats = repository.loadCatsSuspend()
            view.showResults(cats)
        } catch (exception: Exception) {
            view.showError()
        }
        view.hideProgress()
    }
}

interface MyView {
    fun showProgress()
    fun hideProgress()
    fun showError()
    fun showResults(cats: List<Cat>)
}
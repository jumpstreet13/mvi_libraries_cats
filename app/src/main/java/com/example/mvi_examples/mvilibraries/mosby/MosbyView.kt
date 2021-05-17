package com.example.mvi_examples.mvilibraries.mosby

import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.Observable

interface MosbyView : MvpView {

    fun loadCatsIntent(): Observable<Boolean>
    fun render(viewState: MosbyViewState)
}
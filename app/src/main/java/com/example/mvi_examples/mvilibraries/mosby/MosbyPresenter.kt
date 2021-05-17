package com.example.mvi_examples.mvilibraries.mosby

import com.example.mvi_examples.mvilibraries.CatsRepository
import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

class MosbyPresenter : MviBasePresenter<MosbyView, MosbyViewState>() {

    private val repository = CatsRepository()

    override fun bindIntents() {
        val loadCats: Observable<MosbyViewState> = intent(MosbyView::loadCatsIntent)
            .switchMap {
                repository.loadMosbyCats()
                    .toObservable()
            }
            .map { catList ->
                MosbyViewState(
                    isLoading = false,
                    catList = catList,
                    error = null
                )
            }
            .scan { lastState: MosbyViewState, currentState: MosbyViewState ->
                reduceState(lastState, currentState)
            }
            .startWith(
                MosbyViewState(
                    catList = emptyList(),
                    isLoading = true,
                    error = null
                )
            )
            .onErrorReturn { throwable ->
                MosbyViewState(
                    catList = emptyList(),
                    isLoading = false,
                    error = throwable
                )
            }
            .observeOn(AndroidSchedulers.mainThread())

        subscribeViewState(loadCats, MosbyView::render)
    }

    private fun reduceState(lastState: MosbyViewState, currentState: MosbyViewState): MosbyViewState {
        return currentState
    }
}
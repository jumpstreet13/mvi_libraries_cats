package com.example.mvi_examples.mvilibraries.roxie

import android.util.Log
import com.example.mvi_examples.mvilibraries.CatsRepository
import com.ww.roxie.BaseViewModel
import com.ww.roxie.Reducer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RoxieViewModel(
    initialState: RoxieState?,
    private val repository: CatsRepository
) : BaseViewModel<RoxieAction, RoxieState>() {

    override val initialState = initialState ?: RoxieState(isIdle = true)

    private val reducer: Reducer<RoxieState, RoxieChange> = { state, change ->
        when (change) {
            is RoxieChange.Loading -> state.copy(
                isIdle = false,
                isLoading = true,
                cats = emptyList(),
                isLoadError = false
            )
            is RoxieChange.Cats -> state.copy(
                isLoading = false,
                cats = change.catsList,
                isLoadError = false
            )
            is RoxieChange.Error -> state.copy(
                isLoading = false,
                isLoadError = true,
                error = change.throwable
            )
        }
    }

    init {
        bindActions()
    }

    private fun bindActions() {
        val loadCatsChange = actions.ofType(RoxieAction.LoadCats::class.java)
            .switchMap {
                repository.loadMosbyCats()
                    .subscribeOn(Schedulers.io())
                    .toObservable()
                    .map<RoxieChange> { RoxieChange.Cats(it) }
                    .defaultIfEmpty(RoxieChange.Cats(emptyList()))
                    .onErrorReturn { RoxieChange.Error(it) }
                    .startWith(RoxieChange.Loading)
            }


        disposables.add(loadCatsChange
            .scan(initialState, reducer)
            //.filter { !it.isIdle }
            .distinctUntilChanged()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(state::setValue) { Log.e("Error", it.toString()) }
        )
    }
}
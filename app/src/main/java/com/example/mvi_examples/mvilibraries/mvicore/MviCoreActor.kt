package com.example.mvi_examples.mvilibraries.mvicore

import com.example.mvi_examples.mvilibraries.Cat
import com.example.mvi_examples.mvilibraries.CatsRepository
import com.badoo.mvicore.element.Actor
import io.reactivex.Observable
import io.reactivex.Observable.just
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MviCoreActor : Actor<MviCoreState, MviCoreWish, MviCoreEffect> {

    private val catsRepository = CatsRepository()

    override fun invoke(state: MviCoreState, wish: MviCoreWish): Observable<out MviCoreEffect> {
        return when (wish) {
            is MviCoreWish.LoadCats -> loadCats()
                .map { MviCoreEffect.LoadedCats(it) as MviCoreEffect }
                .startWith(just(MviCoreEffect.StartedLoading))
                .onErrorReturn { MviCoreEffect.ErrorLoading(it) }
        }
    }

    private fun loadCats(): Observable<List<Cat>> {
        return catsRepository.loadMosbyCats()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .toObservable()
    }
}
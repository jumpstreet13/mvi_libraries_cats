package com.example.mvi_examples.mvilibraries

import com.mooveit.library.Fakeit
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class CatsRepository(
) {

    init {
        Fakeit.initWithLocale("ru")
    }

    fun loadMosbyCats(): Single<List<Cat>> {
        return ServiceProvider.catService.getKitties()
            .map { list -> list.map { it.copy(catName = Fakeit.name().name()) } }
            .subscribeOn(Schedulers.io())
    }

    suspend fun loadCatsSuspend(): List<Cat> {
        return ServiceProvider.catService.getKittiesSuspend()
            .map { it.copy(catName = Fakeit.name().name()) }
    }
}
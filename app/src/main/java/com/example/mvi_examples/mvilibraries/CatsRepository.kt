package com.example.mvi_examples.mvilibraries

import android.content.Context
import com.mooveit.library.Fakeit
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

interface ResourceWrapper {
    fun getString()
}

class ResourceWrapperImpl(private val context: Context): ResourceWrapper {

    override fun getString() {
        context.getString()
    }
}

class CatsRepository(
    val resourceWrapper: ResourceWrapper
){

    init {
        Fakeit.initWithLocale("ru")
    }

    fun loadMosbyCats(): Single<List<Cat>> {
        resourceWrapper.getString()
        return ServiceProvider.catService.getKitties()
            .map { list -> list.map { it.copy(catName = Fakeit.name().name()) } }
            .subscribeOn(Schedulers.io())
    }

    suspend fun loadCatsSuspend(): List<Cat> {
        return ServiceProvider.catService.getKittiesSuspend()
            .map { it.copy(catName = Fakeit.name().name()) }
    }
}